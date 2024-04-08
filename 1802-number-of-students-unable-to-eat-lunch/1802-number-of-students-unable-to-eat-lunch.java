class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = Arrays.stream(students).boxed().collect(
            Collectors.toCollection(LinkedList::new)
        );

        int remainingStudents = q.size();

        for (int i = 0; i < sandwiches.length; i++) {
            int sandwich = sandwiches[i];

            int student = q.remove();

            int n = q.size();

            while (sandwich != student) {
                if (n == 0) {
                    return q.size() + 1;
                }

                q.add(student);
                student = q.remove();
                n--;
            }
        }

        return 0;
    }
}