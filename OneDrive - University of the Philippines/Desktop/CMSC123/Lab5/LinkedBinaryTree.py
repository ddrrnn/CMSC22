class BTNode:
    def __init__(self, value):
        self.value = value
        self.parent = None
        self.left = None
        self.right = None

    def getValue(self):
        return self.value

    def setParent(self, parent):
        self.parent = parent

    def setLeft(self, child):
        self.left = child

    def getLeft(self):
        return self.left

    def setRight(self, child):
        self.right = child

    def getRight(self):
        return self.right


class LinkedBinaryTree:
    def __init__(self):
        self.root = None
        self.size = 0

    def setRoot(self, value):
        root = BTNode(value)
        self.root = root

    def getRoot(self):
        return self.root

    def setLeft(self, parent, value):
        child = BTNode(value)
        child.setParent(parent)
        parent.setLeft(child)

    def setRight(self, parent, value):
        child = BTNode(value)
        child.setParent(parent)
        parent.setRight(child)


def inorderTraversal(node):
    output = []
    if node is not None:
        left = node.getLeft()
        right = node.getRight()

        output.extend(inorderTraversal(left))

        value = node.getValue()
        output.append(value)

        output.extend(inorderTraversal(right))
    
    return output


def preorderTraversal(node):
    output = []
    if node is not None:
        left = node.getLeft()
        right = node.getRight()

        value = node.getValue()
        output.append(value)

        output.extend(preorderTraversal(left))
        output.extend(preorderTraversal(right))

    return output


def postorderTraversal(node):
    output = []
    if node is not None:
        left = node.getLeft()
        right = node.getRight()

        output.extend(postorderTraversal(left))
        output.extend(postorderTraversal(right))

        value = node.getValue()
        output.append(value)

    return output

#      1
#     /  \
#   2      3
#  /  \
# 4    5

linkedtree = LinkedBinaryTree()
linkedtree.setRoot(1)
root = linkedtree.getRoot()

linkedtree.setLeft(root, 2)
linkedtree.setLeft(root.getLeft(), 4)
linkedtree.setRight(root.getLeft().getLeft(), 5)

linkedtree.setRight(root, 3)

inorder = inorderTraversal(root)
preorder = preorderTraversal(root)
postorder  = postorderTraversal(root)

print("Inorder Traversal:", inorder)
print("Preorder Traversal:", preorder)
print("Postorder Traversal:", postorder)