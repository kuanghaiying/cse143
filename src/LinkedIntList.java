import java.util.NoSuchElementException;

public class LinkedIntList {
    private ListNode front;

    public LinkedIntList(int max) {
        for (int i = max; i >= 0; i--) {
            front = new ListNode(i, front);
        }
    }

    public LinkedIntList() {
        front = null;
    }

    public int size() {
        ListNode current = front;
        int size = 0;
        while (current != null) {
            current = current.next;
            size++;
        }
        return size;
    }

    public int get(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public int indexOf(int value) {
        int index = 0;
        ListNode current = front;
        while (current != null && current.data != value) {
            current = current.next;
            index++;
        }
        if (current != null) {
            return index;
        } else {
            return -1;
        }
    }

    public void add(int n) {
        if (front == null) {
            front = new ListNode(n);
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode(n);
            current.next.next = null;
        }
    }

    public void addSorted$(int value) {
        if (front == null || value < front.data) {
            front = new ListNode(value, front);
        } else {
            ListNode current = front;
            while (current.next != null && value > current.next.data) {
                current = current.next;
            }
            current.next = new ListNode(value, current.next);
        }
    }

    public void add(int index, int n) {
        if (index == 0) {
            front = new ListNode(n, front);
        } else {
            ListNode current = front;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            ListNode after = current.next;

            current = front;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }

            current.next = null;
            current.next = new ListNode();
            current.next.data = n;
            current.next.next = after;
        }
    }

    public void addSorted(int value) {
        if (front == null || front.data >= value) {
            front = new ListNode(value, front);
        } else {
            ListNode current = front;
            while (current.next != null && current.next.data < value) {
                current = current.next;
            }
            current.next = new ListNode(value, current.next);
        }

    }

    public void addSortedInchworm(int value) {

    }

    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "";
            ListNode current = front;
            result += "[" + front.data;
            current = current.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    public boolean hasTwoConsecutive() {
        if (front == null) {
            return false;
        }
        int lastNum = front.data;
        ListNode current = front.next;
        while (current != null) {
            int currentNum = current.data;
            if (currentNum == lastNum + 1) {
                return true;
            }
            lastNum = currentNum;
            current = current.next;
        }
        return false;
    }

    public int deleteBack() {
        if (front == null) {
            throw new NoSuchElementException();
        }
        ListNode current = front;
        if (current.next != null) {
            while (current.next.next != null) {
                current = current.next;
            }
            int last = current.next.data;
            current.next = null;
            return last;
        } else { // the list only has one element
            int last = front.data;
            front = null;
            return last;
        }
    }

    public void stutter() {
        ListNode current = front;
        while (current!= null) {
            current.next = new ListNode(current.data, current.next);
            current = current.next.next;
        }
    }

    public void remove(int index) {
        if (index == 0) {
            front = front.next;
        } else {
            ListNode current = front;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
    }

    public int lastIndexOf(int value) {
        int index = 0;
        int indexResult = 0;
        ListNode current = front;
        while (current != null) {
            if (current.data == value) {
                indexResult = index;
            }
            current = current.next;
            index++;
        }
        if (indexResult == 0 && front.data != value) {
            return -1;
        } else {
            return indexResult;
        }
    }

    public boolean removeFirst(int value) {
        if (front != null) {
            if (front.data == value) {
                front = front.next;
                return true;
            }
            ListNode current = front;
            while (current.next != null && current.next.data != value) {
                current = current.next;
            }
            if (current.next != null) {
                current.next = current.next.next;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean isSorted() {
        if (front != null) {
            int lastNum = front.data;
            ListNode current = front.next;
            while (current != null) {
                int currNum = current.data;
                if (currNum < lastNum) {
                    return false;
                }
                lastNum = currNum;
                current = current.next;
            }
            return true;
        }
        return true;
    }

    public boolean isSorted$() {
        if (front != null) {
            ListNode current = front;
            while (current.next != null) {
                if (current.data > current.next.data) {
                    return false;
                }
                current = current.next;
            }
        }
        return true;
    }

    public void repeat() {
        if (front != null) {
            ListNode current = front;
            while (current != null) {
                current.next = new ListNode(current.data, current.next);
                current = current.next.next;
            }
        }
    }

    public void reverse3() {
        ListNode previous = front;
        ListNode current = front;
        int count = 0;
        while (current != null) {
            count++;
            if (count % 3 == 0) {
                ListNode temp = current.next;
                if (count == 3) {
                    System.out.println(current.data);
                    current.next = previous.next;
                    previous.next.next = previous;
                    previous.next = temp;
                    front = current;
                } else {
                    current.next = previous.next.next;
                    previous.next.next.next = previous.next;
                    previous.next.next = temp;
                    previous.next = current;
                    previous = previous.next.next.next;
                }
                current = current.next.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public void reverse3$() {
        if (front != null && front.next != null && front.next.next != null) {
            ListNode temp = front;
            front = front.next.next;
            ListNode temp2 = front.next;
            front.next = temp.next;
            temp.next.next = temp;
            temp.next = temp2;
            while (temp.next != null && temp.next.next != null && temp.next.next.next != null) {
                temp.next = temp.next.next.next;
                temp = temp2;
                temp2 = temp.next.next.next;
                temp.next.next.next = temp.next;
                temp.next.next = temp;
                temp.next = temp2;
            }
        }
    }

    public void removeAll(int value) {
        while (front != null && front.data == value) {
            front = front.next;
        }
        ListNode current = front;
        while (current != null && current.next != null) {
            if (current.next.data == value) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public void split() {
        if (front != null && front.next != null) {
            ListNode former = front;
            ListNode later = front.next;
            while (later != null) {
                if (later.data < 0) {
                    former.next = former.next.next;
                    later.next = front;
                    front = later;
                    later = former.next;
                } else {
                    former = former.next;
                    later = later.next;
                }
            }
        }
    }

    public boolean equals(LinkedIntList other) {
        if (this.front == null || other.front == null) {
            return this.front == other.front;
        } else {
            ListNode curr1 = this.front;
            ListNode curr2 = other.front;
            while (curr1 != null && curr2 != null) {
                if (curr1.data != curr2.data) {
                    return false;
                }
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
            return curr1 == curr2;
        }
    }

    public void doubleList() {
        int size = 0;
        ListNode later = front;
        while (later != null && later.next != null) {
            size++;
            later = later.next;
        }
        if (front != null) {
            size++;
        }
        ListNode former = front;
        for (int i = 0; i < size; i++) {
            later.next = new ListNode(former.data);
            later = later.next;
            former = former.next;
        }
    }
    
    public void shift() {
       if (front != null && front.next != null && front.next.next != null) {
           ListNode front2 = front.next;
           ListNode curr2 = front2;
           front.next = front.next.next;
           ListNode curr = front.next;
           while (curr != null && curr.next != null) {
               curr2.next = curr.next;
               curr.next = curr.next.next;
               curr = curr.next;
               curr2 = curr2.next;
           }
           curr2.next = null;
           curr = front;
           while (curr.next != null) {
               curr = curr.next;
           }
           curr.next = front2;
       }
   }

   public void removeFirstSmaller() {
        if (front != null && front.next != null) {
            if (front.data < front.next.data) {
                front = front.next;
            } else {
                ListNode former = front;
                ListNode later = front.next;
                while (later.next != null && later.next.data <= later.data) {
                    former = former.next;
                    later = later.next;
                }
                if (later.next != null) {
                    former.next = later.next;
                }
            }
        }
   }

   public void switchPairs() {
        if (front != null && front.next != null) {
            ListNode temp = front.next.next;
            front.next.next = front;
            front = front.next;
            front.next.next = temp;
            ListNode curr = front.next;
            while (curr.next != null && curr.next.next != null) {
                temp = curr.next.next.next;
                curr.next.next.next = curr.next;
                curr.next = curr.next.next;
                curr.next.next.next = temp;
                curr = curr.next.next;
            }
        }
   }

   public void reverse() {
        if (front != null && front.next != null) {
            int count = 0;
            ListNode later = front;
            while (later.next != null) {
                later = later.next;
                count++;
            }
            ListNode temp = later;
            for (int i = count - 1; i >= 0; i--) {
                ListNode former = front;
                for (int j = 0; j <= i; j++) {
                    former = former.next;
                }
                later.next = former;
                later = former;
            }
            front.next = null;
            front = temp;
        }
   }

   public void takeSmallerFrom(LinkedIntList list2) {
        if (front != null && list2.front != null) {
            if (front.data > list2.front.data) {
                ListNode temp = list2.front.next;
                list2.front.next = front.next;
                front.next = temp;
                temp = front;
                front = list2.front;
                list2.front = temp;
            }
            ListNode curr1 = front;
            ListNode curr2 = list2.front;
            while (curr1.next != null && curr2.next != null) {
                if (curr1.next.data > curr2.next.data) {
                    ListNode middle1 = curr1.next;
                    curr1.next = curr2.next;
                    ListNode later2 = curr2.next.next;
                    curr2.next.next = middle1.next;
                    curr2.next = middle1;
                    middle1.next = later2;
                }
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
        }
   }

   public void addListAt(ListNode front2, int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }
        ListNode lastOf2 = front2;
        while (lastOf2 != null && lastOf2.next != null) {
            lastOf2 = lastOf2.next;
        }
        if (index == 0) {
            if (lastOf2 != null) {
                lastOf2.next = front;
                front = front2;
            }
        } else {
            int currIndex = 0;
            ListNode currNode = front;
            while (currIndex < index - 1 && currNode != null) {
                currNode = currNode.next;
                currIndex++;
            }
            if (currNode == null) {
                throw new IllegalArgumentException();
            }
            if (lastOf2 != null) {
                lastOf2.next = currNode.next;
                currNode.next = front2;
            }
        }
   }

   public boolean bubble() {
        boolean changed = false;
        if (front != null && front.next != null) {
            if (front.data > front.next.data) {
                ListNode temp = front.next;
                front.next = temp.next;
                temp.next = front;
                front = temp;
                changed = true;
            }
            ListNode current = front;
            while (current.next.next != null) {
                if (current.next.data > current.next.next.data) {
                    ListNode temp = current.next.next;
                    current.next.next = temp.next;
                    temp.next = current.next;
                    current.next = temp;
                    changed = true;
                }
                current = current.next;
            }
        }
        return changed;
   }

   public void collapse() {
        if (front != null && front.next != null) {
            front.data += front.next.data;
            front.next = front.next.next;
            ListNode curr = front;
            while (curr.next != null && curr.next.next != null) {
                curr.next.data += curr.next.next.data;
                curr.next.next = curr.next.next.next;
                curr = curr.next;
            }
        }
   }

   public void compress(int n) {
        ListNode curr = front;
        int length = 0;
        while (curr != null) {
            curr = curr.next;
            length++;
        }
        if (length < n) {
            curr = front;
            int sum = 0;
            while (curr != null) {
                sum += curr.data;
                curr = curr.next;
            }
            front.data = sum;
            front.next = null;
        } else {
            int sum = 0;
            int period = length / n;
            curr = front;
            for (int i = 1; i <= n; i++) {
                sum += curr.data;
                curr = curr.next;
            }
            front.data = sum;
            front.next = curr;
            ListNode last = curr;
            for (int i = 1; i <= period - 1; i++) {
                sum = 0;
                for (int j = 1; j <= n; j++) {
                    sum += curr.data;
                    curr = curr.next;
                }
                last.data = sum;
                last.next = curr;
                last = curr;
            }
            sum = 0;
            if (length % n != 0) {
                while (curr != null) {
                    sum += curr.data;
                    curr = curr.next;
                }
                last.data = sum;
                last.next = null;
            }
        }
   }

   public void compressDuplicate() {
        if (front != null) {
            ListNode curr = front;
            int count = 1;
            int n = curr.data;
            while (curr.next != null && curr.next.data == n) {
                count++;
                curr = curr.next;
            }
            front = new ListNode(count, curr);
            while (curr.next != null) {
                ListNode last = curr;
                count = 0;
                n = curr.next.data;
                while (curr.next != null && curr.next.data == n) {
                    count++;
                    curr = curr.next;
                }
                if (count != 0) {
                    last.next = new ListNode(count, curr);
                }
            }
        }
   }

   public int evenSum() {
        int index = 0;
        int sum = 0;
        ListNode curr = front;
        while (curr != null) {
            if (index % 2 == 0) {
                sum += curr.data;
            }
            index++;
            curr = curr.next;
        }
        return sum;
    }

    public void expand(int f) {
        if (front != null) {
            if (f <= 0) {
                front = null;
            } else if (f != 1) {
                int n = front.data;
                int value = n / f;
                ListNode insert = new ListNode(value);
                ListNode curr = insert;
                for (int i = 1; i <= f - 1; i++) {
                    insert = new ListNode(value, insert);
                }
                curr.next = front.next;
                front = insert;
                while (curr.next != null) {
                    n = curr.next.data;
                    value = n / f;
                    insert = new ListNode(value);
                    ListNode later = insert;
                    for (int i = 1; i <= f - 1; i++) {
                        insert = new ListNode(value, insert);
                    }
                    later.next = curr.next.next;
                    curr.next = insert;
                    curr = later;
                }
            }
        }
    }

    public void frontToBack() {
        if (front != null) {
            ListNode curr = front;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = front;
            front = front.next;
            curr.next.next = null;
        }
    }

    public boolean hasAlternatingParity() {
        if (front != null && front.next != null) {
            ListNode curr = front;
            while (curr.next != null) {
                if (curr.data % 2 == curr.next.data % 2) {
                    return false;
                }
                curr = curr.next;
            }
        }
        return true;
    }

    public boolean hasDuplicate() {
        if (front != null && front.next != null) {
            ListNode curr1 = front;
            while (curr1.next != null) {
                ListNode curr2 = curr1.next;
                int n = curr1.data;
                while (curr2 != null) {
                    if (curr2.data == n) {
                        return true;
                    }
                    curr2 = curr2.next;
                }
                curr1 = curr1.next;
            }
        }
        return false;
    }

    public boolean hasOddEven() {
        boolean hasOdd = false;
        boolean hasEven = false;
        ListNode curr = front;
        while (curr != null && (!hasOdd || !hasEven)) {
            if (curr.data % 2 == 0) {
                hasEven = true;
            } else {
                hasOdd = true;
            }
            curr = curr.next;
        }
        return hasOdd && hasEven;
    }

    public boolean increasingTriples() {
        if (front != null && front.next != null) {
            ListNode curr = front;
            while (curr != null) {
                int times = 1;
                while (curr.next != null && times <= 2) {
                    if (curr.data >= curr.next.data) {
                        return false;
                    }
                    curr = curr.next;
                    times++;
                }
                curr = curr.next;
            }
        }
        return true;
    }

    public void insertMultiplesOfN(int n) {
        if (front != null) {
            if (front.data != 0) {
                front = new ListNode(0, front);
            }
            int multiple = 1;
            ListNode curr = front;
            while (curr != null && curr.next != null) {
                while (curr.next != null && curr.next.data < multiple * n) {
                    curr = curr.next;
                }
                if (curr.next != null) {
                    if (curr.next.data > multiple * n) {
                        curr.next = new ListNode(multiple * n, curr.next);
                    }
                    multiple++;
                } else if (curr.data % n != 0) {
                    curr.next = new ListNode(multiple * n);
                }
                curr = curr.next;
            }
        } else {
            front = new ListNode(0);
        }
    }

    public void interleave(LinkedIntList other) {
        if (other.front != null) {
            if (front == null) {
                front = other.front;
            } else {
                ListNode curr = front;
                while (curr.next != null && other.front != null) {
                    ListNode temp1 = curr.next;
                    curr.next = other.front;
                    ListNode temp2 = other.front.next;
                    other.front.next = temp1;
                    other.front = temp2;
                    curr = temp1;
                }
                if (curr.next == null) {
                    curr.next = other.front;
                }
            }
            other.front = null;
        }
    }

    public boolean isConsecutive() {
        if (front != null && front.next != null) {
            ListNode curr = front;
            while (curr.next != null) {
                if (curr.data != curr.next.data - 1) {
                    return false;
                }
                curr = curr.next;
            }
        }
        return true;
    }

    public boolean isSortedByN$(int n) {
        ListNode curr = front;
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }
        if (length <= n) {
            return true;
        }
        ListNode start = front;
        for (int i = 1; i <= n; i++) {
            ListNode last = start;
            curr = last;
            int times = 1;
            while (curr != null && times <= n) {
                curr = curr.next;
                times++;
            }
            while (curr != null) {
                System.out.println("last: " + last.data);
                System.out.println("curr: " + curr.data);
                if (last.data > curr.data) {
                    return false;
                }
                last = curr;
                times = 1;
                while (curr != null && times <= n) {
                    curr = curr.next;
                    times++;
                }
            }
            start = start.next;
            System.out.println("-----------------------------");
        }
        return true;
    }

    public boolean isSortedByN(int n) {
        ListNode start = front;
        for (int i = 1; i <= n; i++) {
            ListNode last = start;
            ListNode curr = start;
            int times = 1;
            while (curr != null && times <= n) {
                curr = curr.next;
                times++;
            }
            if (curr == null) {
                return true;
            }
            while (curr != null) {
                if (last.data > curr.data) {
                    return false;
                }
                last = curr;
                times = 1;
                while (curr != null && times <= n) {
                    curr = curr.next;
                    times++;
                }
                if (curr == null) {
                    return true;
                }
            }
            start = start.next;
        }
        return true;
    }

    public void markMultiples(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        if (front != null) {
            ListNode curr = front;
            if (front.data % n == 0) {
                front = new ListNode(0, front);
                curr = front.next.next;
            }
            while (curr.next != null) {
                if (curr.next.data % n == 0) {
                    curr.next = new ListNode(0, curr.next);
                    curr = curr.next.next;
                } else {
                    curr = curr.next;
                }
            }
        }
    }

    public int maxAdjacentPairSum() {
        if (front != null && front.next != null) {
            int sum = front.data + front.next.data;
            int max = sum;
            ListNode curr = front.next;
            while (curr.next != null) {
                sum = curr.data + curr.next.data;
                if (sum > max) {
                    max = sum;
                }
                curr = curr.next;
            }
            return max;
        } else if (front == null) {
            return 0;
        } else {
            return front.data;
        }
    }

    public void minToFront() {
        if (front != null) {
            ListNode curr = front;
            ListNode beforeMin = front;
            int min = front.data;
            while (curr.next != null) {
                if (curr.next.data < min) {
                    min = curr.next.data;
                    beforeMin = curr;
                }
                curr = curr.next;
            }
            ListNode minNode = beforeMin.next;
            if (beforeMin.next != null && min != front.data) {
                beforeMin.next = beforeMin.next.next;
                minNode.next = front;
                front = minNode;
            }
        }
    }

    public int numUnique() {
        if (front != null) {
            int count = 1;
            int last = front.data;
            ListNode curr = front.next;
            while (curr != null) {
                if (curr.data != last) {
                    count++;
                    last = curr.data;
                }
                curr = curr.next;
            }
            return count;
        } else {
            return 0;
        }
    }

    public void trimEnds(int n) {
        if (n > 0) {
            ListNode curr = front;
            int length = 0;
            while (curr != null) {
                curr = curr.next;
                length++;
            }
            if (length < 2 * n) {
                throw new IllegalArgumentException();
            }
            for (int i = 0; i < n; i++) {
                front = front.next;
            }
            curr = front;
            length = 0;
            while (curr != null) {
                curr = curr.next;
                length++;
            }
            if (length == n) {
                front = null;
            } else {
                curr = front;
                for (int i = 0; i < length - n - 1; i++) {
                    curr = curr.next;
                }
                curr.next = null;
            }
        }
    }

    public int shiftLastOf3() {
        int length = 0;
        ListNode curr = front;
        while (curr != null) {
            curr = curr.next;
            length++;
        }
        if (length / 3 >= 1) {
            ListNode temp = front.next.next;
            front.next.next = temp.next;
            ListNode shift = temp;
            curr = temp.next;
            shift.next = null;
            for (int i = 0; i < length / 3 - 1; i++) {
                curr = curr.next;
                temp = curr.next;
                curr.next = temp.next;
                ListNode currShift = shift;
                while (currShift.next != null) {
                    currShift = currShift.next;
                }
                currShift.next = temp;
                curr = temp.next;
                temp.next = null;
            }
            curr = shift;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = front;
            front = shift;
        }
        return length / 3;
    }

    public void switchEvens(LinkedIntList other) {
        if (front != null && front.next != null && other.front != null && other.front.next != null) {
            ListNode temp1 = front.next;
            front.next = other.front.next;
            other.front.next = temp1;
            ListNode temp2 = other.front;
            other.front = front;
            front = temp2;
            ListNode curr1 = front.next;
            ListNode curr2 = other.front.next;
            while (curr1 != null && curr2 != null && curr1.next != null && curr2.next != null) {
                ListNode middle1 = curr1.next;
                curr1.next = curr2.next;
                ListNode last2 = curr2.next.next;
                curr2.next.next = middle1.next;
                curr2.next = middle1;
                curr1 = middle1.next;
                middle1.next = last2;
                curr2 = last2;
            }
        }
    }

    public void surroundWith(int x, int y) {
        if (front != null) {
            ListNode curr = front;
            if (front.data == x) {
                front = new ListNode(y, front);
                front.next.next = new ListNode(y, front.next.next);
                curr = front.next.next;
            }
            while (curr.next != null) {
                if (curr.next.data == x) {
                    curr.next = new ListNode(y, curr.next);
                    curr.next.next.next = new ListNode(y, curr.next.next.next);
                    curr = curr.next.next.next;
                } else {
                    curr = curr.next;
                }
            }
        }
    }

    public void stutterTwo() {
        ListNode curr = front;
        while (curr != null && curr.next != null) {
            curr.next.next = new ListNode(curr.data, curr.next.next);
            curr.next.next.next = new ListNode(curr.next.data, curr.next.next.next);
            curr = curr.next.next.next.next;
        }
    }

    public void sortPairs() {
        if (front != null && front.next != null) {
            ListNode curr = front;
            if (front.data > front.next.data) {
                front = front.next;
                ListNode later = front.next;
                front.next = curr;
                curr.next = later;
            } else {
                curr = curr.next;
            }
            while (curr.next != null && curr.next.next != null) {
                if (curr.next.data > curr.next.next.data) {
                    ListNode middle = curr.next;
                    curr.next = curr.next.next;
                    ListNode later = curr.next.next;
                    curr.next.next = middle;
                    middle.next = later;
                    curr = middle;
                } else {
                    curr = curr.next.next;
                }
            }
        }
    }

    public void mergeWith(LinkedIntList other) {
        if (other.front != null) {
            if (front != null) {
                if (other.front.data < front.data) {
                    ListNode temp = front;
                    front = other.front;
                    other.front = other.front.next;
                    front.next = temp;
                }
                ListNode curr1 = front;
                while (other.front != null && curr1.next != null) {
                    if (other.front.data < curr1.next.data) {
                        ListNode temp1 = curr1.next;
                        curr1.next = other.front;
                        other.front = other.front.next;
                        curr1.next.next = temp1;
                    }
                    curr1 = curr1.next;
                }
                curr1.next = other.front;
            } else {
                front = other.front;
            }
            other.front = null;
        }
    }

    public void printEvenOddSum() {
        boolean isEven = true;
        int evenSum = 0;
        int oddSum = 0;
        ListNode curr = front;
        while (curr != null) {
            if (isEven) {
                evenSum += curr.data;
            } else {
                oddSum += curr.data;
            }
            isEven = !isEven;
            curr = curr.next;
        }
        System.out.println("even sum = " + evenSum);
        System.out.println("odd sum = " + oddSum);
    }

    public void printInversion() {
        ListNode curr = front;
        while (curr != null && curr.next != null) {
            ListNode later = curr.next;
            while (later != null) {
                if (later.data < curr.data) {
                    System.out.println("(" + curr.data + ", " + later.data + ")");
                }
                later = later.next;
            }
            curr = curr.next;
        }
    }

    public void reOrder() {
        if (front != null && front.next != null) {
            ListNode negative = null;
            while (front != null && front.data < 0) {
                ListNode temp = front.next;
                front.next = negative;
                negative = front;
                front = temp;
            }
            ListNode curr = front;
            while (curr != null && curr.next != null) {
                if (curr.next.data < 0) {
                    ListNode temp = curr.next;
                    curr.next = curr.next.next;
                    temp.next = negative;
                    negative = temp;
                } else {
                    curr = curr.next;
                }
            }
            curr = negative;
            while (curr != null && curr.next != null) {
                curr = curr.next;
            }
            if (curr != null) {
                curr.next = front;
                front = negative;
            }
        }
    }

    public void rearrange() {
        if (front != null && front.next != null && front.next.next != null) {
            ListNode even = front;
            front = front.next;
            even.next = null;
            ListNode curr = front;
            while (curr != null && curr.next != null) {
                ListNode temp = curr.next;
                curr.next = curr.next.next;
                temp.next = even;
                even = temp;
                curr = curr.next;
            }
            curr = even;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = front;
            front = even;
        }
    }

    public LinkedIntList removeEvens() {
        if (front == null) {
            throw new IllegalArgumentException();
        }
        LinkedIntList result = new LinkedIntList();
        if (front.next != null) {
            result.front = front;
            ListNode currInResult = front;
            front = front.next;
            currInResult.next = null;
            ListNode curr = front;
            while (curr != null && curr.next != null) {
                currInResult.next = curr.next;
                curr.next = curr.next.next;
                currInResult = currInResult.next;
                currInResult.next = null;
                curr = curr.next;
            }
        } else {
            result.front = front;
            front = null;
        }
        return result;
    }

    public void removeEveryIthElement(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        if (n != 1) {
            ListNode curr = front;
            int length = 0;
            while (curr != null) {
                curr = curr.next;
                length++;
            }
            int times = length / n;
            curr = front;
            for (int i = 0; i < times; i++) {
                for (int j = 0; j < n - 2; j++) {
                    curr = curr.next;
                }
                curr.next = curr.next.next;
                curr = curr.next;
            }
        } else {
            front = null;
        }
    }

    public LinkedIntList removeAlternating() {
        LinkedIntList result = new LinkedIntList();
        if (front != null && front.next != null) {
            result.front = front;
            ListNode currInResult = front;
            front = front.next;
            ListNode curr = front;
            boolean isFirst = false;
            while (curr != null && curr.next != null && curr.next.next != null) {
                if (!isFirst) {
                    currInResult.next = curr.next.next;
                    currInResult = currInResult.next;
                    curr = curr.next.next;
                } else {
                    currInResult.next = curr.next;
                    currInResult = currInResult.next;
                    curr.next = curr.next.next;
                }
                curr = curr.next;
                isFirst = !isFirst;
            }
            currInResult.next = null;
        }
        return result;
    }
}
