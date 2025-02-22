package questions.hard;
// 1028. Recover a Tree From Preorder Traversal
// Solved
// Hard
// Topics
// Companies
// Hint
// We run a preorder depth-first search (DFS) on the root of a binary tree.

// At each node in this traversal, we output D dashes (where D is the depth of this node), then we output the value of this node.  If the depth of a node is D, the depth of its immediate child is D + 1.  The depth of the root node is 0.

// If a node has only one child, that child is guaranteed to be the left child.

// Given the output traversal of this traversal, recover the tree and return its root.

 

// Example 1:


// Input: traversal = "1-2--3--4-5--6--7"
// Output: [1,2,5,3,4,6,7]
// Example 2:


// Input: traversal = "1-2--3---4-5--6---7"
// Output: [1,2,5,3,null,6,null,4,null,7]
// Example 3:


// Input: traversal = "1-401--349---90--88"
// Output: [1,401,null,349,88,90]
 

// Constraints:

// The number of nodes in the original tree is in the range [1, 1000].
// 1 <= Node.val <= 109

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RecursiveDFS {
    class Solution {
    public TreeNode recoverFromPreorder(String s) {
        List<int[]> vp = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            int depth = 0;
            while (i < s.length() && s.charAt(i) == '-') {
                depth++;
                i++;
            }
            int num = 0;
            while (i < s.length() && s.charAt(i) != '-') {
                num = num * 10 + (s.charAt(i) - '0');
                i++;
            }
            vp.add(new int[]{depth, num});
        }

        Stack<Pair<Integer, TreeNode>> st = new Stack<>();
        TreeNode root = null;
        
        for (int[] it : vp) {
            int depth = it[0];
            int nodeVal = it[1];
            TreeNode node = new TreeNode(nodeVal);

            while (!st.isEmpty() && st.peek().getKey() >= depth) {
                st.pop();
            }

            if (!st.isEmpty()) {
                TreeNode parent = st.peek().getValue();
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            } else {
                root = node;
            }

            st.push(new Pair<>(depth, node));
        }
        
        return root;
    }
}
}
