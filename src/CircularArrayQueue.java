import java.util.NoSuchElementException;

public class CircularArrayQueue<E> implements Queue211<Object> {
  private E[] data;
  private E temp;
  private int front = -1;
  private int end = 0;
  private int size = 0;


  CircularArrayQueue() {

  }


  @SuppressWarnings("unchecked")
  @Override
  public boolean add(Object e) {
    if (size == data.length) {
      reallocate();
      // throw new IllegalStateException();
    }
    else {
      data[end] = (E) e;
      end = (end + 1) % data.length;
    }

    return true;
  }


  @Override
  public Object element() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    else {
      return data[front];
    }
  }


  @Override
  public boolean offer(Object e) {
    try {
      return add(e);
    }
    catch (IllegalStateException ise) {
      return false;
    }
  }


  @Override
  public Object peek() {
    try {
      return element();
    }
    catch (NoSuchElementException nsee) {
      return null;
    }
  }


  @Override
  public Object poll() {
    try {
      return remove();
    }
    catch (NoSuchElementException nsee) {
      return null;
    }
  }


  @Override
  public Object remove() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    else {
      temp = data[front];
      front = (front + 1) % data.length;
      return temp;
    }
  }


  @Override
  public int size() {
    return size;
  }


  // moves array objects to an array of double the size
  @SuppressWarnings("unchecked")
  private void reallocate() {
    Object[] dataTemp = new Object[data.length * 2];
    for (int i = 0; i < size; i++) {
      dataTemp[i] = (data[front + i % data.length]);
    }
    data = (E[]) dataTemp;
    size = size * 2;
  }

}