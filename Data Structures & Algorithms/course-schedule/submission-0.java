
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];

            graph.get(prereq).add(course);
        }

        int[] state = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, graph, state)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(int course, List<List<Integer>> graph, int[] state) {
        if (state[course] == 1) {
            return true;
        }

        if (state[course] == 2) {
            return false;
        }

        state[course] = 1;

        for (int nextCourse : graph.get(course)) {
            if (hasCycle(nextCourse, graph, state)) {
                return true;
            }
        }

        state[course] = 2;
        return false;
    }
}