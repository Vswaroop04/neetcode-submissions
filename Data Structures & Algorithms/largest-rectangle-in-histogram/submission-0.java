class Solution {

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        int[] prevSmaller = previousSmaller(heights);

        int[] nextSmaller = nextSmaller(heights);

        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            int width =
                nextSmaller[i]
                - prevSmaller[i]
                - 1;

            int area = heights[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public int[] previousSmaller(int[] arr) {

        int n = arr.length;

        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (
                !stack.isEmpty() &&
                arr[stack.peek()] >= arr[i]
            ) {

                stack.pop();
            }

            if (stack.isEmpty()) {

                result[i] = -1;

            } else {

                result[i] = stack.peek();
            }

            stack.push(i);
        }

        return result;
    }

    public int[] nextSmaller(int[] arr) {

        int n = arr.length;

        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (
                !stack.isEmpty() &&
                arr[stack.peek()] >= arr[i]
            ) {

                stack.pop();
            }

            if (stack.isEmpty()) {

                result[i] = n;

            } else {

                result[i] = stack.peek();
            }

            stack.push(i);
        }

        return result;
    }
}