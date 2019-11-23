public class LetterInventoryClient {
    public static void main(String[] args) {
        LetterInventory letter = new LetterInventory("aBC !@#%^$&*^*&%abcdabcd");
        System.out.println(letter);
        LetterInventory letter2 = new LetterInventory("abcabcabc");
        System.out.println(letter2);
        LetterInventory sum = letter.add(letter2);
        System.out.println(sum);
        System.out.println("size = " + sum.size());
        sum.set('B', 1);
        System.out.println(sum);
        System.out.println(Character.toLowerCase('Á'));
        System.out.println(letter.isEmpty());
        LetterInventory newLetter = letter.subtract(letter);
        System.out.println(newLetter.isEmpty());
        System.out.println(newLetter);
    }
}
