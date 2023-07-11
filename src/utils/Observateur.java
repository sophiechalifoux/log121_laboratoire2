package utils;

public interface Observateur<T> {

    void onChanged(T newValue);
}
