package of.samiron;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInRelativeOrder;

class TreeNodeTest {

    TreeNode tree = new TreeNode("root",
            new TreeNode("A1",
                    new TreeNode("A1A2"),
                    new TreeNode("A1B2",
                            new TreeNode("A1B2A3"),
                            new TreeNode("A1B2B3"),
                            new TreeNode("A1B2C3")
                    )
            ),
            new TreeNode("B1"),
            new TreeNode("C1",
                    new TreeNode("C1A2"),
                    new TreeNode("C1B2",
                            new TreeNode("C1B2A3"),
                            new TreeNode("C1B2B3"),
                            new TreeNode("C1B2C3")
                    )
            )
    );


    @Test
    public void namesOfNthRow() {
        {
            List<String> actualNames = TreeNode.TreeUtil.namesOnNthRow(tree, 2);
            assertThat(actualNames, containsInRelativeOrder("A1A2", "A1B2", "C1A2", "C1B2"));
        }

        {
            List<String> actualNames = TreeNode.TreeUtil.namesOnNthRow(tree, 3);
            assertThat(actualNames, containsInRelativeOrder("A1B2A3", "A1B2B3", "A1B2C3", "C1B2A3", "C1B2B3", "C1B2C3"));
        }

    }

}