import java.util.*;

public class CollectionsProgramming {
    public static void main(String[] args) {
        String[] arr = {"Basic", "C", "C++", "Haskell", "Java", "Ruby", "Scheme", "VisualBasic"};
        Set<String> set = new TreeSet<>();
        for (String str : arr) {
            set.add(str);
        }
        Set<String> result = exactShorterThan(set, 5);
        System.out.println(set);
        System.out.println(result);
    }

    public static Map<Integer, String> byAge(Map<String, Integer> nameMap, int min, int max) {
        Map<Integer, String> ageMap = new TreeMap<>();
        for (String name : nameMap.keySet()) {
            int age = nameMap.get(name);
            if (age <= max && age >= min) {
                if (!ageMap.containsKey(age)) {
                    ageMap.put(age, name);
                } else {
                    ageMap.put(age, ageMap.get(age) + " and " + name);
                }
            }
        }
        return ageMap;
    }

    public static Set<String> cancelCourse(Map<String, Set<String>> studentCourse, String cancel) {
        Set<String> changedStudent = new TreeSet<>();
        for (String name : studentCourse.keySet()) {
            if (studentCourse.get(name).contains(cancel)) {
                studentCourse.get(name).remove(cancel);
                changedStudent.add(name);
            }
        }
        return changedStudent;
    }

    public static Set<String> commonFirstLetters(List<String> list) {
        Set<String> result = new HashSet<>();
        Set<String> all = new HashSet<>();
        for (String word : list) {
            String firstLetter = word.substring(0, 1);
            if (all.contains(firstLetter)) {
                result.add(firstLetter);
            } else {
                all.add(firstLetter);
                all.add(firstLetter.toLowerCase());
                all.add(firstLetter.toUpperCase());
            }
        }
        return result;
    }

    public static Map<String, List<String>> commonHobbies(Map<String, List<String>> taName) {
        Map<String, List<String>> result = new TreeMap<>();
        for (String name : taName.keySet()) {
            List<String> hobbies = taName.get(name);
            for (String hobby : hobbies) {
                if (result.containsKey(hobby)) {
                    result.get(hobby).add(name);
                } else {
                    List<String> nameList = new ArrayList<>();
                    nameList.add(name);
                    result.put(hobby, nameList);
                }
            }
        }
        return result;
    }

    public static int duplicateValues(Map<String, String> m) {
        Set<String> all = new HashSet<>();
        int count = 0;
        for (String key : m.keySet()) {
            if (!all.contains(m.get(key))) {
                all.add(m.get(key));
            } else {
                count++;
            }
        }
        return count;
    }

    public static int rarestAge(Map<String, Integer> nameAge) {
        Map<Integer, Integer> ageTimes = new TreeMap<>();
        for (String name : nameAge.keySet()) {
            int age = nameAge.get(name);
            if (!ageTimes.containsKey(age)) {
                ageTimes.put(age, 1);
            } else {
                ageTimes.put(age, ageTimes.get(age) + 1);
            }
        }
        Iterator<Integer> itr = ageTimes.keySet().iterator();
        int age = itr.next();
        int min = ageTimes.get(age);
        while (itr.hasNext()) {
            int currAge = itr.next();
            int times = ageTimes.get(currAge);
            if (times < min) {
                min = times;
                age = currAge;
            }
        }
        return age;
    }

    public static Map<String, Integer> computeTotalCredits(Map<String, Set<String>> enrollments,
                                                           Map<String, Integer> credits) {
        Map<String, Integer> result = new TreeMap<>();
        for (String name : enrollments.keySet()) {
            int total = 0;
            for (String currentCourse : enrollments.get(name)) {
                total += credits.get(currentCourse);
            }
            result.put(name, total);
        }
        return result;
    }

    public static Set<String> whereinTheWorld(String city, Map<String, Set<String>> places) {
        Set<String> people = new TreeSet<>();
        for (String name : places.keySet()) {
            if (places.get(name).contains(city)) {
                people.add(name);
            }
        }
        return people;
    }

    public static Map<String, List<String>> deepCopy(Map<String, List<String>> map) {
        Map<String, List<String>> result = new TreeMap<>();
        for (String key : map.keySet()) {
            List<String> listCopy = new ArrayList<>();
            for (String value : map.get(key)) {
                listCopy.add(value);
            }
            result.put(key, listCopy);
        }
        return result;
    }

    public static Set<String> exactShorterThan(Set<String> set, int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        Set<String> result = new TreeSet<>();
        Iterator<String> itr = set.iterator();
        while (itr.hasNext()) {
            String curr = itr.next();
            if (curr.length() < n) {
                itr.remove();
                result.add(curr);
            }
        }
        return result;
    }

    public static void printOverSpent(Map<String, Double> map) {
        for (String name : map.keySet()) {
            double debit = map.get(name);
            if (debit < 0) {
                System.out.println(name + " " + debit);
            }
        }
    }

    public static int countInAreaCode(Map<String, String> map, String code) {
        Set<String> phoneNum = new HashSet<>();
        for (String name : map.keySet()) {
            String num = map.get(name);
            if (num.substring(0, 3).equals(code)) {
                phoneNum.add(num);
            }
        }
        return phoneNum.size();
    }

    public static Map<String, List<Integer>> studentGrades(Map<String, Map<String, Integer>> prof) {
        Map<String, List<Integer>> result = new TreeMap<>();
        for (String profName : prof.keySet()) {
            Map<String, Integer> grades = prof.get(profName);
            for (String studentName : grades.keySet()) {
                if (!result.containsKey(studentName)) {
                    result.put(studentName, new ArrayList<>());
                }
                result.get(studentName).add(grades.get(studentName));
            }
        }
        return result;
    }

    public Map<String, List<Set<String>>> acronyms(List<Set<String>> wordsList) {
        Map<String, List<Set<String>>> result = new TreeMap<>();
        for (Set<String> phrase : wordsList) {
            String acronym = "";
            for (String word : phrase) {
                acronym += word.charAt(0);
            }
            if (!result.containsKey(acronym)) {
                result.put(acronym, new ArrayList<>());
            }
            result.get(acronym).add(phrase);
        }
        return result;
    }

//    public Map<String, Set<String>> birthdayMonth(Map<String, Date> birthdayInfo) {
//        Map<String, Set<String>> result = new TreeMap<>();
//        for (String name : birthdayInfo.keySet()) {
//            String month = birthdayInfo.get(name).getMonth();
//            if (!result.containsKey(month)) {
//                result.put(month, new TreeSet<>());
//            }
//            result.get(month).add(name);
//        }
//        return result;
//    }

    public int recordDate(Map<String, List<String>> dateInfo, String person1, String person2) {
        if (!dateInfo.containsKey(person1)) {
            dateInfo.put(person1, new LinkedList<>());
        }
        if (!dateInfo.containsKey(person2)) {
            dateInfo.put(person2, new LinkedList<>());
        }
        dateInfo.get(person1).add(0, person2);
        dateInfo.get(person2).add(0, person1);
        int count = 0;
        for (String name : dateInfo.get(person1)) {
            if (name.equals(person2)) {
                count++;
            }
        }
        return count;
    }
}
