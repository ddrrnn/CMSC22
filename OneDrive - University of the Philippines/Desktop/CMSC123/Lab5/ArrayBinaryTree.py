#Array implementation from lab 1
class Element:
	def __init__(self, value, index):
		self.value = value
		self.index = index

	def setValue(self, value):
		self.value = value

	def getValue(self):
		return self.value

class Array:
	def __init__(self):
		self.size = 0
		self.contents = []

	def isEmpty(self):
		return (self.size == 0)

	def addElement(self, value):
		element = Element(value, self.size) 
		self.contents = self.contents + [element]
		self.size += 1 

	def removeElement(self, index):
		if 0 <= index < self.size:
			self.contents = self.contents[:index] + self.contents[index+1:]
			self.size -= 1

class ArrayBinaryTree:
    def __init__(self):
        self.array = Array()
        self.rootIndex = None

    def setRoot(self, value):
        if self.rootIndex is not None: #if the root exists already
            self.array.contents[self.rootIndex].setValue(value)
        else: #no root yet
            self.array.addElement(value)
            self.rootIndex = 0

    def getRoot(self):
        if self.rootIndex is not None:
            return self.array.contents[self.rootIndex].getValue()
        else:
            return None

    def setLeft(self, parentIndex, value):
        if parentIndex is not None and 0 <= parentIndex < self.array.size: #parentIndex exists and it is in the bounds of the array
            leftChildIndex = 2 * parentIndex + 1
            if leftChildIndex >= self.array.size:
                while len(self.array.contents) <= leftChildIndex: #if left child index is out of bounds, add elements (None)
                    self.array.addElement(None)
            self.array.contents[leftChildIndex].setValue(value)

    def setRight(self, parentIndex, value):
        if parentIndex is not None and 0 <= parentIndex < self.array.size:
            rightChildIndex = 2 * parentIndex + 2
            if rightChildIndex >= self.array.size:
                while len(self.array.contents) <= rightChildIndex: #if right child index is out of bounds, add elements (None)
                    self.array.addElement(None)
            self.array.contents[rightChildIndex].setValue(value)
    
def inorderTraversal(index):
    output = []
    if index is not None and 0 <= index < arraytree.array.size:
        output.extend(inorderTraversal(2 * index + 1))  # traverse left subtree
        output.append(arraytree.array.contents[index].getValue())  # go back to root
        output.extend(inorderTraversal(2 * index + 2))  # traverse right subtree
    return output

def preorderTraversal(index):
    output = []
    if index is not None and 0 <= index < arraytree.array.size:
        output.append(arraytree.array.contents[index].getValue())  # root
        output.extend(preorderTraversal(2 * index + 1))  # left
        output.extend(preorderTraversal(2 * index + 2))  # right
    return output

def postorderTraversal(index):
    output = []
    if index is not None and 0 <= index < arraytree.array.size:
        output.extend(postorderTraversal(2 * index + 1))  # left
        output.extend(postorderTraversal(2 * index + 2))  # right
        output.append(arraytree.array.contents[index].getValue())  # root
    return output


#      1
#     /  \
#   2      3
#  /  \
# 4    5

arraytree = ArrayBinaryTree()
arraytree.setRoot(1)
arraytree.setLeft(0, 2)
arraytree.setRight(0, 3)
arraytree.setLeft(1, 4)
arraytree.setRight(1, 5)

print("Inorder Traversal:", inorderTraversal(0))
print("Preorder Traversal:", preorderTraversal(0))
print("Postorder Traversal:", postorderTraversal(0))
