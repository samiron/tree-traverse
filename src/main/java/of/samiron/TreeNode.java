package of.samiron;

import java.util.*;

public class TreeNode {

    private String name;
    private List<TreeNode> children;

    public TreeNode(String name, TreeNode... children) {
        this.name = name;
        this.children = Arrays.asList(children);
    }

    public String getName() {
        return name;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public static class TreeUtil {

        private static List<String> getNames(TreeNode node, int current, int n) {
            if(current == n) {
                return Arrays.asList(node.getName());
            } else {
                List<String> names = new ArrayList<>();
                for(TreeNode tc : node.getChildren()) {
                    names.addAll(getNames(tc, current + 1, n));
                }
                return names;
            }
        }

        public static List<String> namesOnNthRow(TreeNode root, int n) {
            return getNames(root, 0, n);
        }

    }
}


