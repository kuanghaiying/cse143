import java.lang.reflect.Array;
import java.util.*;

public class ArrayIntList implements IntList {

    private int[] elementData;
    private int size;

    public ArrayIntList() {
        this(1000);
    }

    public ArrayIntList(int capacity) {
        elementData = new int[capacity];
        size = 0;
    }

    public void add(int element) {
        elementData[size] = element;
        size++;
    }

    public void add(int index, int value) {
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = value;
        size++;
    }

    public void remove(int index) {
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
    }

    public void removeAll(int target) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == target) {
                remove(i);
                i--;
            }
        }
    }

    public int indexOf(int value) {
        for (int i = 0 ; i < size; i++) {
            if (elementData[i] == value) {
                return i;
            }
        }
        return -1;

//        int index = 0;
//        while (elementData[index] != value && index < size) {
//            index++;
//        }
//        if (index < size) {
//            return index;
//        } else {
//            return -1;
//        }
    }

    public int get(int index) {
        return elementData[index];
    }

    public void repeat() {
        int oldSize = size;
        for (int i = 0; i < oldSize; i++) {
            for (int j = size; j > i * 2 + 1; j--) {
                elementData[j] = elementData[j - 1];
            }
            size++;
            elementData[i * 2 + 1] = elementData[i * 2];
        }
    }

    public void betterRepeat() {
        for (int i = size - 1; i >= 0; i--) {
            elementData[i * 2 + 1] = elementData[i];
            elementData[i * 2] = elementData[i];
        }
        size *= 2;
    }

    public int maxCount() {
        if (size == 0) {
            return 0;
        }
        int last = elementData[0];
        int count = 1;
        int max = count;
        for (int i = 1; i < size; i++) {
            if (elementData[i] == last) {
                count++;
            } else {
                count = 1;
                last = elementData[i];
            }
            if (count > max) {
                max = count;
            }
        }
        return max;
    }

    public void mirror() {
        for (int i = size - 1; i >= 0; i--) {
            elementData[size * 2 - i - 1] = elementData[i];
        }
        size *= 2;
    }

    public ArrayIntList fromCounts() {
        ArrayIntList result = new ArrayIntList();
        int time = 0;
        for (int i = 0; i < size; i++) {
            if (i % 2 == 0 && i != 1) {
                time = elementData[i];
            } else {
                for (int j = 0; j < time; j++) {
                    result.elementData[result.size] = elementData[i];
                    result.size++;
                }
            }
        }
        return result;
    }

    // this is the solution from the answer sheet
    public ArrayIntList formCounts$() {
        ArrayIntList result = new ArrayIntList();
        int size2 = 0;
        for (int i = 0; i < size; i += 2) {
            for (int j = 0; j < elementData[i]; j++) {
                result.elementData[size2] = elementData[i + 1];
                size2++;
            }
        }
        result.size = size2;
        return result;
    }

    public String toString() {
        String list = "[";
        if (size > 0) {
            list += elementData[0];
        }
        for (int i = 1; i < size; i++) {
            list += ", " + elementData[i];
        }
        list += "]";
        return list;
    }

    public void ensureCapacity(int capacity) {
        if (elementData.length < capacity) {
            int[] newElementData = new int[capacity];
            for (int i = 0; i < size; i++) {
                newElementData[i] = elementData[i];
            }
            elementData = newElementData;
        }
    }

    public void takeMax(ArrayIntList other) {
        if (other.size > this.size) {
            ensureCapacity(other.size);
            this.size = other.size;
        }
        for (int i = 0; i < Math.min(other.size, this.size); i++) {
            if (other.elementData[i] > this.elementData[i]) {
                this.elementData[i] = other.elementData[i];
            }
        }
        if (other.size > this.size) {
            for (int i = this.size; i < other.size; i++) {
                this.elementData[i] = other.elementData[i];
            }
        }
    }

    public ArrayIntList reverseCopy() {
        ArrayIntList result = new ArrayIntList(this.elementData.length);
        for (int i = this.size - 1; i >= 0; i--) {
            result.elementData[this.size - 1 - i] = this.elementData[i];
        }
        result.size = this.size;
        return result;
    }

    public void retainAll(Set<Integer> s) {
        for (int i = 0; i < size; i++) {
            if (!s.contains(elementData[i])) {
                for (int j = i; j < size - 1; j++) {
                    elementData[j] = elementData[j + 1];
                }
                size--;
                i--;
            }
        }
    }

    public void removeRange(int start, int end) {
        if (start > end || start > size || end > size) {
            throw new IllegalArgumentException();
        }
        for (int i = end + 1; i < size; i++) {
            elementData[i - (end - start + 1)] = elementData[i];
        }
        size = size - (end - start + 1);
    }

    public boolean removeLast(int n) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (elementData[i] == n) {
                index = i;
            }
        }
        if (index != -1) {
            for (int i = index + 1; i < size; i++) {
                elementData[i - 1] = elementData[i];
            }
            size--;
        }
        return index != -1;
    }

    public void mirror$() {
        for (int i = size - 1; i >= 0; i--) {
            elementData[size * 2 - 1 - i] = elementData[i];
        }
        size *= 2;
    }

    public void collapse() {
        for (int i = 0; i < size - 1; i += 2) {
            elementData[i / 2] = elementData[i] + elementData[i + 1];
        }
        if (size % 2 != 0) {
            elementData[size / 2] = elementData[size - 1];
        }
        size = (size + 1) / 2;
    }

    public void copyMultiple(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < size; j++) {
                elementData[i * size + j] = elementData[j];
            }
        }
        size *= n;
    }

    public ArrayIntList extractOddIndexes() {
        ArrayIntList result = new ArrayIntList();
        for (int i = 1; i < size; i += 2) {
            result.elementData[i / 2] = elementData[i];
        }
        for (int i = 2; i < size; i+= 2) {
            elementData[i / 2] = elementData[i];
        }
        int oldSize = size;
        size = size / 2 + size % 2;
        result.size = oldSize - size;
        return result;
    }

    public ArrayIntList fromCounts$$() {
        ArrayIntList result = new ArrayIntList();
        int index = 0;
        for (int i = 0; i < size - 1; i += 2) {
            for (int j = 0; j < elementData[i]; j++) {
                result.elementData[index] = elementData[i + 1];
                index++;
                result.size++;
            }
        }
        return result;
    }

    public int longestSortedSequence() {
        if (size == 0) {
            return 0;
        }
        int max = 1;
        int count = 1;
        int last = elementData[0];
        for (int i = 1; i < size; i++) {
            int curr = elementData[i];
            if (curr >= last) {
                count++;
                if (count > max) {
                    max = count;
                }
            } else {
                count = 1;
            }
            last = curr;
        }
        return max;
    }

    public ArrayIntList makePalindrome() {
        ArrayIntList result = new ArrayIntList();
        for (int i = 0; i < size; i++) {
            result.elementData[i] = elementData[i];
        }
        if (size % 2 == 0) {
            for (int i = size; i < size * 2; i++) {
                result.elementData[i] = elementData[size * 2 - 1 - i];
            }
            result.size = size * 2;
        } else {
            for (int i = size; i < size * 2 - 1; i++) {
                result.elementData[i] = elementData[size * 2 - 2 - i];
            }
            result.size = size * 2 - 1;
        }
        return result;
    }
}