class Node {
    constructor(data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    constructor(head = null) {
        this.head = head;
        this.tail = null;
    }

    find(data) {
        let current = this.head;
        while (current !== null) {
            if (current.data === data) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    append(data) {
        const newNode = new Node(data);
        if (this.head === null) {
            this.head = newNode;
            this.tail = this.head;
        } else {
            this.tail.next = newNode;
            this.tail = newNode;
        }
    }
    
    insert(node, data) {
        const newNode = new Node(data);
        newNode.next = node.next;
        node.next = newNode;
    }

    remove(data) {
        let previous = this.head;
        while(previous.next !== null) {
            if (previous.next.data === data) {
                previous.next = previous.next.next;
                return;
            }
            previous = previous.next;
        }
    }

    display() {
        let current = this.head;
        let display = '[';
        while (current !== null) {
            display += current.data + ' ';
            current = current.next;
        }
        display = display.substring(0, display.length - 1);
        display += ']';
        console.log(display);
    }
}

const list = new LinkedList();
list.append(1)
list.append(2)
list.append(3)
list.append(4)
list.display()
list.remove(3)
list.display()
list.insert(list.find(2), 3)
list.display()
