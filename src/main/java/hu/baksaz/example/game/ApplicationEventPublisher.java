package hu.baksaz.example.game;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ApplicationEventPublisher {

  private List<ApplicationEventListener<? extends Event>> listeners = new ArrayList<>();

  public void listen(ApplicationEventListener<? extends Event> listener) {
    listeners.add(listener);
  }

  public void publish(Event event) {
    for (ApplicationEventListener<? extends Event> listener : listeners) {
      Class<?> listenerType = resolveEventType(listener);

      if (listenerType != null && listenerType.isAssignableFrom(event.getClass())) {
        invokeListener(listener, event);
      }
    }
  }

  private static void invokeListener(ApplicationEventListener<? extends Event> listener, Event event) {
    try {
      ((ApplicationEventListener<Event>) listener).onApplicationEvent(event);
    } catch (ClassCastException e) {
      // Skip incompatible listener
    }
  }

  private static Class<?> resolveEventType(ApplicationEventListener<? extends Event> listener) {
    for (Type iface : listener.getClass().getGenericInterfaces()) {
      if (iface instanceof ParameterizedType paramType &&
          paramType.getRawType() == ApplicationEventListener.class) {
        Type actualType = paramType.getActualTypeArguments()[0];
        if (actualType instanceof Class<?>) {
          return (Class<?>) actualType;
        }
      }
    }
    return null;
  }
}
