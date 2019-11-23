import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IntTree {
    private IntTreeNode overallRoot;

    private static class IntTreeNode {
        public int data;
        public IntTreeNode left;
        public IntTreeNode right;

        public IntTreeNode(int data) {
            this(data, null, null);
        }
        public IntTreeNode(int data, IntTreeNode left, IntTreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public void printPreorder() {
        System.out.print("preorder:");
        printPreorder(overallRoot);

    }

    private void printPreorder(IntTreeNode root) {
        if (root != null) {
            System.out.print(" " + root.data);
            printPreorder(root.left);
            printPreorder(root.right);
        }
    }

    public IntTree() {
        overallRoot = null;
    }

    public IntTree(int max) {
        if (max < 0) {
            throw new IllegalArgumentException("max: " + max);
        }
        overallRoot = buildTree(1, max);
    }

    private IntTreeNode buildTree(int n, int max) {
        if (n > max) {
            return null;
        } else {
            return new IntTreeNode(n, buildTree(2 * n, max), buildTree(2 * n + 1, max));
        }
    }

    public void printSideWay() {
        printSideWay(0, overallRoot);
    }

    private void printSideWay(int level, IntTreeNode root) {
        if (root != null) {
            printSideWay(level + 1, root.right);
            for (int i = 0; i < level; i++) {
                System.out.print("    ");
            }
            System.out.println(root.data);
            printSideWay(level + 1, root.left);
        }
    }

    public int sum() {
        return sum(overallRoot);
    }

    private int sum(IntTreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return root.data + sum(root.left) + sum(root.right);
        }
    }

    public int countLevel() {
        return countLevel(overallRoot);
    }

    private int countLevel(IntTreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return 1 + Math.max(countLevel(root.left), countLevel(root.right));
        }
    }

    public int countLeaves() {
        return countLeaves(overallRoot);
    }

    private int countLeaves(IntTreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null){
            return 1;
        } else {
            return countLeaves(root.left) + countLeaves(root.right);
        }
    }

    public void add(int value) {
        overallRoot = add(overallRoot, value);
    }

    private IntTreeNode add(IntTreeNode root, int value) {
        if (root == null) {
            root = new IntTreeNode(value);
        } else if (value <= root.data) {
            root.left = add(root.left, value);
        } else {
            root.right = add(root.right, value);
        }
        return root;
    }

    public boolean equals(IntTree other) {
        return equals(this.overallRoot, other.overallRoot);
    }

    private boolean equals(IntTreeNode root1, IntTreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        } else {
            return root1.data == root2.data && equals(root1.left, root2.left) &&
                    equals(root1.right, root2.right);
        }
    }

    public void writeTree() {
        writeTree(overallRoot);
    }

    private void writeTree(IntTreeNode root) {
        if (root.left == null && root.right == null) {
            System.out.println("0 " + root.data);
        } else if (root.left == null) {
            System.out.println("2 " + root.data);
            writeTree(root.right);
        } else if (root.right == null) {
            System.out.println("1 " + root.data);
            writeTree(root.left);
        } else {
            System.out.println("3 " + root.data);
            writeTree(root.left);
            writeTree(root.right);
        }
    }

    private void writeTree$(IntTreeNode root) {
        if (root != null) {
            int code = 0;
            if (root.left != null) {
                code += 1;
            }
            if (root.right != null) {
                code += 2;
            }
            System.out.println(code + " " + root.data);
            writeTree$(root.left);
            writeTree$(root.right);
        }
    }

    public int depthSum() {
        return depthSum(overallRoot, 1);
    }

    private int depthSum(IntTreeNode root, int level) {
        if (root == null) {
            return 0;
        } else {
            return level * root.data + depthSum(root.left, level + 1) +
                    depthSum(root.right, level + 1);
        }
    }

    public int height() {
        return height(overallRoot);
    }

    private int height(IntTreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = 1 + height(root.left);
            int rightHeight = 1 + height(root.right);
            return leftHeight > rightHeight ? leftHeight : rightHeight;
        }
    }

    public boolean isFull() {
        return isFull(overallRoot);
    }

    private boolean isFull(IntTreeNode root) {
        if (root == null) {
            return true;
        } else if (root.left == null || root.right == null){
            return root.left == root.right;
        } else {
            return isFull(root.left) && isFull(root.right);
        }
    }

    public void printLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException();
        }
        printLevel(overallRoot, level);
    }

    private void printLevel(IntTreeNode root, int level) {
        if (root != null) {
            if (level == 1) {
                System.out.println(root.data);
            } else {
                printLevel(root.left, level - 1);
                printLevel(root.right, level - 1);
            }
        }
    }

    public boolean hasPathSum(int n) {
        return hasPathSum(overallRoot, n, 0);
    }

    private boolean hasPathSum(IntTreeNode root, int n, int sum) {
        if (root == null) {
            return false;
        } else {
            int curr = root.data;
            if (curr + sum == n) {
                return true;
            } else if (curr + sum > n) {
                return false;
            } else {
                return hasPathSum(root.left, n, sum + curr) ||
                        hasPathSum(root.right, n, sum + curr);
            }
        }
    }

    public void removeLeaves() {
        overallRoot = removeLeaves(overallRoot);
    }

    private IntTreeNode removeLeaves(IntTreeNode root) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                root = null;
            } else {
                root.left = removeLeaves(root.left);
                root.right = removeLeaves(root.right);
            }
        }
        return root;
    }

    public void limitPathSum(int max) {
        overallRoot = limitPathSum(0, max, overallRoot);
    }

    private IntTreeNode limitPathSum(int sum, int max, IntTreeNode root) {
        if (root != null) {
            if (sum + root.data <= max) {
                root.left = limitPathSum(sum + root.data, max, root.left);
                root.right = limitPathSum(sum + root.data, max, root.right);
                return root;
            }
        }
        return null;
    }

    public void construct(int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        overallRoot = construct(0, n - 1);
    }

    private IntTreeNode construct(int low, int high) {
        if (low <= high) {
            int mid = (low + high) / 2;
            return new IntTreeNode(mid, construct(low, mid -1), construct(mid + 1, high));
        } else {
            return null;
        }
    }

    public void completeToLevel(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        overallRoot = completeToLevel(n, overallRoot);
    }

    private IntTreeNode completeToLevel(int n, IntTreeNode root) {
        if (n > 0) {
            if (root == null) {
                root = new IntTreeNode(-1);
            }
            root.left = completeToLevel(n - 1, root.left);
            root.right = completeToLevel(n - 1, root.right);
        }
        return root;
    }

    public void tighten() {
        overallRoot = tighten(overallRoot);
    }

    private IntTreeNode tighten(IntTreeNode root) {
        if (root != null) {
            if (root.left == null && root.right != null) {
                return tighten(root.right);
            } else if (root.right == null && root.left != null) {
                return tighten(root.left);
            } else if (root.left != null && root.right != null) {
                root.left = tighten(root.left);
                root.right = tighten(root.right);
            }
        }
        return root;
    }

    public int numberNodes() {
        return numberNodes(overallRoot, 1);
    }

    private int numberNodes(IntTreeNode root, int num) {
        if (root != null) {
            root.data = num;
            int countLeft = numberNodes(root.left, num + 1);
            int countRight = numberNodes(root.right, num + countLeft + 1);
            return 1 + countLeft + countRight;
        } else {
            return 0;
        }
    }

    public int countLeftNodes() {
        return countLeftNodes(overallRoot);
    }

    private int countLeftNodes(IntTreeNode root) {
        int count = 0;
        if (root != null) {
            if (root.left != null) {
                count += 1 + countLeftNodes(root.left);
            }
            if (root.right != null) {
                count += countLeftNodes(root.right);
            }
        }
        return count;
    }

    public int numEmpty() {
        if (overallRoot == null) {
            return 1;
        } else {
            return numEmpty(overallRoot);
        }
    }

    private int numEmpty(IntTreeNode root) {
        if (root != null) {
            int count = 0;
            if (root.left == null) {
                count++;
            }
            if (root.right == null) {
                count++;
            }
            return count + numEmpty(root.left) + numEmpty(root.right);
        } else {
            return 0;
        }
    }

    public String toString() {
        return toString(overallRoot);
    }

    private String toString(IntTreeNode root) {
        if (root == null) {
            return "empty";
        } else if (root.left != null || root.right != null) {
            return "(" + root.data + ", " + toString(root.left) + ", " + toString(root.right) + ")";
        } else {
            return "" + root.data;
        }
    }

    public boolean hasAlternatingParity() {
        return hasAlternatingParity(overallRoot);
    }

    private boolean hasAlternatingParity(IntTreeNode root) {
        if (root == null) {
            return true;
        } else if (root.left == null && root.right == null){
            return true;
        } else {
            boolean isAlternating = true;
            if (root.right != null) {
                if (root.data % 2 == 0) {
                    if (root.right.data % 2 == 0) {
                        isAlternating = false;
                    }
                } else {
                    if (root.right.data % 2 != 0) {
                        isAlternating = false;
                    }
                }
            }
            if (root.left != null) {
                if (root.data % 2 == 0) {
                    if (root.left.data % 2 == 0) {
                        isAlternating = false;
                    }
                } else {
                    if (root.left.data % 2 != 0) {
                        isAlternating = false;
                    }
                }
            }
            return isAlternating && hasAlternatingParity(root.left) && hasAlternatingParity(root.right);
        }
    }

    public boolean contains(IntTree other) {
        return contains(this.overallRoot, other.overallRoot);
    }

    private boolean contains(IntTreeNode thisRoot, IntTreeNode otherRoot) {
        if (otherRoot == null) {
            return true;
        } else {
            return thisRoot.data == otherRoot.data && contains(thisRoot.left, otherRoot.left) &&
                    contains(thisRoot.right, otherRoot.right);
        }
    }

    // pre: given input is in pairs of titles and values
    //      0 represents a leaf node
    //      1 represents a node with only a left subtree
    //      2 represents a node with only a right subtree
    //      3 represents a node with both left and right subtrees
    // post: replaces the current tree as the one read from the given input,
    public void readTree(Scanner input) {
        overallRoot = readHelper(input);
    }

    private IntTreeNode readHelper(Scanner input) {
        int title = input.nextInt();
        int value = input.nextInt();
        IntTreeNode node = new IntTreeNode(value);
        if (title == 1) {
            node.left = readHelper(input);
        } else if (title == 2) {
            node.right = readHelper(input);
        } else if (title == 3) {
            node.left = readHelper(input);
            node.right = readHelper(input);
        }
        return node;
    }

    public int countMultiplies(int n) {
        return countMultiplies(n, overallRoot);
    }

    private int countMultiplies(int n, IntTreeNode root) {
        if (root == null) {
            return 0;
        } else {
            if (root.data % n == 0) {
                return 1 + countMultiplies(n, root.left) + countMultiplies(n, root.right);
            } else {
                return countMultiplies(n, root.left) + countMultiplies(n, root.right);
            }
        }
    }

    public int countOddBranches() {
        return countOddBranches(overallRoot);
    }

    private int countOddBranches(IntTreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null && root.right == null) {
            return 0;
        } else {
            if (root.data % 2 != 0) {
                return 1 + countOddBranches(root.left) + countOddBranches(root.right);
            } else {
                return countOddBranches(root.left) + countOddBranches(root.right);
            }
        }
    }

    public int countTwins() {
        return countTwins(overallRoot);
    }

    private int countTwins(IntTreeNode root) {
        if (root == null) {
            return 0;
        } else if (root.left == null || root.right == null) {
            return 0;
        } else {
            if (root.left.data == root.right.data) {
                return 1 + countTwins(root.left) + countTwins(root.right);
            } else {
                return countTwins(root.left) + countTwins(root.right);
            }
        }
    }

    public boolean hasPath(int start, int end) {
        return hasPath(start, end, false, overallRoot);
    }

    private boolean hasPath(int start, int end, boolean findStart, IntTreeNode root) {
        if (root == null) {
            return false;
        } else {
            if (findStart) {
                if (root.data == end) {
                    return true;
                } else {
                    return hasPath(start, end, true, root.left) ||
                            hasPath(start, end, true, root.right);
                }
            } else {
                if (root.data == start) {
                    if (start == end) {
                        return true;
                    } else {
                        return hasPath(start, end, true, root.left) ||
                                hasPath(start, end, true, root.right);
                    }
                } else {
                    return hasPath(start, end, false, root.left) ||
                            hasPath(start, end, false, root.right);
                }
            }
        }
    }

    public List<Integer> inorderList() {
        List<Integer> result = new ArrayList<>();
        inorderList(overallRoot, result);
        return result;
    }

    private void inorderList(IntTreeNode root, List<Integer> result) {
        if (root != null) {
            inorderList(root.left, result);
            result.add(root.data);
            inorderList(root.right, result);
        }
    }

    public void add(IntTree tree2) {
        overallRoot = add(this.overallRoot, tree2.overallRoot);
    }

    private IntTreeNode add(IntTreeNode thisNode, IntTreeNode otherNode) {
        if (otherNode != null){
            if (thisNode != null) {
                thisNode.data += otherNode.data;
            } else {
                thisNode = new IntTreeNode(otherNode.data);
            }
            thisNode.left = add(thisNode.left, otherNode.left);
            thisNode.right = add(thisNode.right, otherNode.right);
        }
        return thisNode;
    }

    public IntTree combineWith(IntTree t2) {
        IntTree result = new IntTree();
        result.overallRoot = combineWith(this.overallRoot, t2.overallRoot);
        return result;
    }

    private IntTreeNode combineWith(IntTreeNode root1, IntTreeNode root2) {
        if (root1 != null || root2 != null) {
            IntTreeNode node = new IntTreeNode(0);
            if (root1 == null) {
                node.data += 2;
                node.left = combineWith(null, root2.left);
                node.right = combineWith(null, root2.right);
            } else if (root2 == null) {
                node.data += 1;
                node.left = combineWith(root1.left, null);
                node.right = combineWith(root1.right, null);
            } else {
                node.data += 3;
                node.left = combineWith(root1.left, root2.left);
                node.right = combineWith(root1.right, root2.right);
            }
            return node;
        } else {
            return null;
        }
    }

    public void construct(int[] list) {
        overallRoot = construct(0, list.length - 1, list);
    }

    private IntTreeNode construct(int start, int end, int[] list) {
        if (start > end) {
            return null;
        } else {
            int middle = (start + end + 1) / 2;
            IntTreeNode node = new IntTreeNode(list[middle]);
            node.left = construct(start, middle - 1, list);
            node.right = construct(middle + 1, end, list);
            return node;
        }
    }

    public int countBelow(int level) {
        if (level < 1) {
            throw new IllegalArgumentException();
        }
        return countBelow(level, 1, overallRoot);
    }

    private int countBelow(int target, int currLevel, IntTreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int count = countBelow(target, currLevel + 1, root.left) +
                        countBelow(target, currLevel + 1, root.right);
            if (currLevel >= target) {
                count++;
            }
            return count;
        }
    }

    public int countNodes(int leftLink, int rightLink) {
        if (leftLink < 0 || rightLink < 0) {
            throw new IllegalArgumentException();
        }
        return countNodes(leftLink, rightLink, overallRoot);
    }

    private int countNodes(int leftLink, int rightLink, IntTreeNode root) {
        if (root == null || leftLink < 0 || rightLink < 0) {
            return 0;
        } else {
            int count = countNodes(leftLink - 1, rightLink, root.left) +
                        countNodes(leftLink, rightLink - 1, root.right);
            if (leftLink == 0 && rightLink == 0) {
                count++;
            }
            return count;
        }
    }

    public int countPathsOfLength(int n) {
        return countPathsOfLength(n, overallRoot);
    }

    private int countPathsOfLength(int remaining, IntTreeNode root) {
        if (remaining < 0 || root == null) {
            return 0;
        } else if (remaining == 0 && root.left == null && root.right == null) {
            return 1;
        } else {
            return countPathsOfLength(remaining - 1, root.left) +
                    countPathsOfLength(remaining - 1, root.right);
        }
    }

    public void doubleIt() {
        overallRoot = doubleIt(overallRoot);
    }

    private IntTreeNode doubleIt(IntTreeNode root) {
        if (root != null) {
            root.left = new IntTreeNode(2 * root.data, doubleIt(root.left), null);
            root.right = new IntTreeNode(2 * root.data, null, doubleIt(root.right));
        }
        return root;
    }

    public void evenLevels() {
        overallRoot = evenLevels(overallRoot, 1);
    }

    private IntTreeNode evenLevels(IntTreeNode root, int level) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                if (level % 2 != 0) {
                    return null;
                }
            } else {
                root.left = evenLevels(root.left, level + 1);
                root.right = evenLevels(root.right, level + 1);
            }
        }
        return root;
    }

    public void expand() {
        overallRoot = expand(overallRoot);
    }

    private IntTreeNode expand(IntTreeNode root) {
        if (root != null) {
            if (root.left == null && root.right == null) {
                return root;
            } else if (root.left != null && root.right != null) {
                root.left = expand(root.left);
                root.right = expand(root.right);
            } else if (root.left == null) {
                root.left = expand(root.right);
                root.right= expand(root.right);
            } else {
                root.right = expand(root.left);
                root.left = expand(root.left);
            }
        }
        return root;
    }

    public void flip() {
        overallRoot = flip(overallRoot);
    }

    private IntTreeNode flip(IntTreeNode root) {
        if (root != null) {
            root.left = flip(root.right);
            root.right = flip(root.left);
        }
        return root;
    }

    public boolean isBalanced() {
        return isBalanced(overallRoot);
    }

    private boolean isBalanced(IntTreeNode root) {
        if (root == null) {
            return true;
        } else {
            boolean balance = Math.abs(height(root.left) - height(root.right)) <= 1;
            return isBalanced(root.left) && isBalanced(root.right) && balance;
        }
    }

    public void limitLeaves(int n) {
        overallRoot = limitLeaves(n, overallRoot);
    }

    private IntTreeNode limitLeaves(int n, IntTreeNode root) {
        if (root != null) {
            root.left = limitLeaves(n, root.left);
            root.right = limitLeaves(n, root.right);
            if (root.left == null && root.right == null && root.data <= n) {
                return null;
            }
        }
        return root;
    }

    public void makeFull() {
        overallRoot = makeFull(overallRoot);
    }

    private IntTreeNode makeFull(IntTreeNode root) {
        if (root != null) {
            if (root.left == null && root.right != null) {
                return makeFull(root.right);
            } else if (root.left != null && root.right == null) {
                return makeFull(root.left);
            } else {
                root.left = makeFull(root.left);
                root.right = makeFull(root.right);
            }
        }
        return root;
    }

    public int leavesAtDepthN(int n) {
        return leavesAtDepthN(n, 1, overallRoot);
    }

    private int leavesAtDepthN(int level, int curr, IntTreeNode root) {
        if (root != null) {
            int count = leavesAtDepthN(level, curr + 1, root.left) +
                    leavesAtDepthN(level, curr + 1, root.right);
            if (root.left == null && root.right == null && curr == level) {
                count++;
            }
            return count;
        } else {
            return 0;
        }
    }

    public int nodesAtLevels(int start, int end) {
        if (start < 0 || start > end) {
            throw new IllegalArgumentException();
        }
        return nodesAtLevels(start, end, 1, overallRoot);
    }

    private int nodesAtLevels(int start, int end, int curr, IntTreeNode root) {
        if (curr <= end && root != null) {
            int count = nodesAtLevels(start, end, curr + 1, root.left) +
                        nodesAtLevels(start, end, curr + 1, root.right);
            if (curr >= start) {
                count++;
            }
            return count;
        } else {
            return 0;
        }
    }

    public void makePerfect() {
        overallRoot = makePerfect(1, height(), overallRoot);
    }

    private IntTreeNode makePerfect(int curr, int target, IntTreeNode root) {
        if (root == null) {
            if (curr <= target) {
                root = new IntTreeNode(0);
            } else {
                return null;
            }
        }
        root.left = makePerfect(curr + 1, target, root.left);
        root.right = makePerfect(curr + 1, target, root.right);
        return root;
    }

    public int matches(IntTree other) {
        return matches(overallRoot, other.overallRoot);
    }

    private int matches(IntTreeNode root1, IntTreeNode root2) {
        if (root1 != null && root2 != null) {
            int countRemaining = matches(root1.left, root2.left) +
                                    matches(root1.right, root2.right);
            if (root1.data == root2.data) {
                countRemaining++;
            }
            return countRemaining;
        } else {
            return 0;
        }
    }

    public void mirror() {
        overallRoot = mirror(overallRoot);
    }

    private IntTreeNode mirror(IntTreeNode root) {
        if (root != null) {
            IntTreeNode temp = mirror(root.left);
            root.left = mirror(root.right);
            root.right = temp;
        }
        return root;
    }

    public void removeLeftLeaves() {
        overallRoot = removeLeftLeaves(overallRoot);
    }

    private IntTreeNode removeLeftLeaves(IntTreeNode root) {
        if (root != null) {
            root.left = removeLeftLeaves(root.left);
            root.right = removeLeftLeaves(root.right);
            if (root.left != null && root.left.left == null && root.left.right == null) {
                root.left = null;
            }
            return root;
        } else {
            return null;
        }
    }

    public void indicateMatching(IntTree other) {
        overallRoot = indicateMatching(overallRoot, other.overallRoot);
    }

    private IntTreeNode indicateMatching(IntTreeNode root1, IntTreeNode root2) {
        if (root1 == null && root2 != null) {
            root1 = new IntTreeNode(-2);
            root1.left = indicateMatching(root1.left, root2.left);
            root1.right = indicateMatching(root1.right, root2.right);
        } else if (root1 != null && root2 == null) {
            root1 = new IntTreeNode(-1);
            root1.left = indicateMatching(root1.left, null);
            root1.right = indicateMatching(root1.right, null);
        } else if (root1 != null && root2 != null) {
            root1.left = indicateMatching(root1.left, root2.left);
            root1.right = indicateMatching(root1.right, root2.right);
        }
        return root1;
    }

    public boolean hasZeroPath() {
        return hasZeroPath(overallRoot);
    }

    private boolean hasZeroPath(IntTreeNode root) {
        if (root != null) {
            if (root.data == 0) {
                return hasZeroPath(root.left) || hasZeroPath(root.right);
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

    public void removeSmallLeaves(int n) {
        overallRoot = removeSmallLeaves(n, overallRoot);
    }

    private IntTreeNode removeSmallLeaves(int n, IntTreeNode root) {
        if (root != null) {
            root.left = removeSmallLeaves(n, root.left);
            root.right = removeSmallLeaves(n, root.right);
            if (root.left == null && root.right == null && root.data < n) {
                return null;
            } else {
                return root;
            }
        } else {
            return null;
        }
    }

    public void stretch() {
        overallRoot = stretch(overallRoot);
    }

    private IntTreeNode stretch(IntTreeNode root) {
        if (root != null) {
            if (root.left == null && root.right != null) {
                root.right = stretch(root.right);
                root = new IntTreeNode(1, null, root);
            } else if (root.left != null && root.right == null) {
                root.left = stretch(root.left);
                root = new IntTreeNode(1, root, null);
            } else {
                root.left = stretch(root.left);
                root.right = stretch(root.right);
            }
        }
        return root;
    }

    public void swapChildrenAtLevel(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        overallRoot = swapChildrenAtLevel(1, n, overallRoot);
    }

    private IntTreeNode swapChildrenAtLevel(int curr, int n, IntTreeNode root) {
        if (root != null) {
            if (curr < n) {
                root.left = swapChildrenAtLevel(curr + 1, n, root.left);
                root.right = swapChildrenAtLevel(curr + 1, n, root.right);
            } else if (curr == n) {
                IntTreeNode temp = root.left;
                root.left = root.right;
                root.right = temp;
            }
        }
        return root;
    }
}
