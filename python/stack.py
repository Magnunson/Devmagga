class Stack:
    def __init__(self):
        self.items = []

    def push(self, item):
        self.items.append(item)

    def pop(self):
        if not self.isEmpty():
            return self.items.pop()
        raise IndexError("pop from an empty stack")

    def peek(self):
        if not self.isEmpty():
            return self.items[-1]
        raise IndexError("peek from an empty stack")

    def isEmpty(self):
        return len(self.items) == 0

    def size(self):
        return len(self.items)