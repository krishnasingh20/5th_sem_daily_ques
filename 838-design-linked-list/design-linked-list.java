class MyLinkedList {

    ListNode head;
    ListNode tail;
    int size;
    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public int get(int index) {
        if(index >= size) {
            return -1;
        }
        if(index == 0) {
            return head.val;
        }
        if(index == size - 1) {
            return tail.val;
        }
        ListNode temp = head;
        int i = 0;
        while(i < index) {
            i++;
            temp = temp.next;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        ListNode nn = new ListNode();
        nn.val = val;
        if(head == null) {
            head = nn;
            tail = nn;
        }
        else {
            nn.next = head;
            head = nn;
        }
        size++;
    }
    
    public void addAtTail(int val) {
        ListNode nn = new ListNode();
        nn.val = val;
        if(head == null) {
            head = nn;
            tail = nn;
        }
        else {
            tail.next = nn;
            tail = nn;
        }
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index > size) {
            return;
        }
        ListNode nn = new ListNode();
        nn.val = val;
        if(head == null) {
            head = nn;
            tail = nn;
        }
        else if(index == 0) {
            nn.next = head;
            head = nn;
        }
        else if(index == size) {
            tail.next = nn;
            tail = nn;
        }
        else {
            ListNode temp = head;
            int i = 0;
            while(i < index - 1) {
                i++;
                temp = temp.next;
            }
            ListNode next = temp.next;
            temp.next = nn;
            nn.next = next;
        }
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index >= size) {
            return;
        }
        if(index == 0) {
            if(size == 1) {
                head = null;
                tail = null;
            }
            else {
                ListNode next = head.next;
                head.next = null;
                head = next;
            }
        }
        else if(index == size - 1) {
            ListNode temp = head;
            while(temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;
        }
        else {
            ListNode temp = head;
            int i = 0;
            while(i < index - 1) {
                i++;
                temp = temp.next;
            }
            ListNode next = temp.next.next;
            temp.next = next;
        }
        size--;
    }
    class ListNode {
        int val;
        ListNode next;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */