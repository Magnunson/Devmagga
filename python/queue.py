class Queue:
    def __init__(self):
        self.items = []

    def enqueue(self, item):
        self.items.append(item)

    def dequeue(self):
        if not self.isEmpty():
            return self.items.pop(0)
        return None

    def front(self):
        if not self.isEmpty():
            return self.items[0]
        return None

    def isEmpty(self):
        return len(self.items) == 0

    def size(self):
        return len(self.items)