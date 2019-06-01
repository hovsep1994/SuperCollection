import java.util.*;

public class SuperCollection<T> implements List<T> {

    private List<T> list;
    private Set<T> set;

    public SuperCollection() {
        list = new ArrayList<>();
        set = new HashSet<>();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return set.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = list.iterator();
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public T next() {
                return iterator.next();
            }
        };
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return list.toArray(a);
    }

    @Override
    public boolean add(T t) {
        boolean add = set.add(t);
        if (add) {
            list.add(t);
        }
        return add;
    }

    @Override
    public boolean remove(Object o) {
        list.remove(o);
        return set.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return set.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        List<T> tempList = new ArrayList<>(c.size());
        for (T t : c) {
            if (set.add(t)) {
                tempList.add(t);
            }
        }
        if (list.isEmpty()) {
            return false;
        }
        return list.addAll(tempList);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        List<T> tempList = new ArrayList<>(c.size());
        for (T t : c) {
            if (set.add(t)) {
                tempList.add(t);
            }
        }
        if (list.isEmpty()) {
            return false;
        }
        return list.addAll(index, tempList);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        set.removeAll(c);
        return list.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        set.clear();
        list.clear();
    }

    @Override
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public T set(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, T element) {
        if (!set.contains(element)) {
            list.add(index, element);
        }
    }

    @Override
    public T remove(int index) {
        T t = list.get(index);
        set.remove(t);
        return list.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return list.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return list.indexOf(o);
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return list.subList(fromIndex, toIndex);
    }
}
