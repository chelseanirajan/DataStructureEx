import com.sun.security.jgss.GSSUtil;

public class LinkedListEx {
    int length =0;
    Node head = null;
    Node tail = null;

    private static class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }
    }

    public LinkedListEx(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length++;

    }

    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }
    public void append(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }
    public int removeLast(){
        Node temp = head;
        Node prev = head;
        while(temp.next != null){
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        tail = prev;
        length--;
        return temp.value;

    }
    public void prepend(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public int removeFirst(){
        Node temp = head;
        head = head.next;
        length--;
        return temp.value;
    }
    public int get(int index){
        if(index<0 || index>length-1) return 0;
        Node temp = head;
        for(int i = 0;i<index;i++){
            temp = temp.next;
        }
        return temp.value;
    }

    public void set(int index, int value){
        if(index<0 || index>length-1) return;
        Node temp = head;
        for(int i = 0;i<index;i++){
            temp = temp.next;
        }
         temp.value = value;
    }

    public boolean insert(int index, int value){
        Node newNode = new Node(value);
        if(index<0 || index>length-1) return false;
        Node temp = head;
        Node pre = head;
        for(int i = 0;i<index;i++){
            pre = temp;
            temp = temp.next;
        }
        pre.next = newNode;
        newNode.next = temp;
        length++;
        return true;
    }

    public int remove(int index){
        if(index<0 || index>length-1) return 0;
        if(index == 0){
            return removeFirst();
        }
        if(index == length-1){
            return removeLast();
        }

        Node temp = head;
        Node pre = head;
        int tempValue = temp.value;
        for(int i = 0;i<index;i++){
            pre = temp;
            temp = temp.next;
        }
        pre.next = temp.next;
        length--;
        return temp.value;
    }
    public void reverse(){

    }

    public static void main(String[] args) {
        LinkedListEx ex = new LinkedListEx(2);
        ex.append(5);
        ex.append(7);
        ex.append(8);
        ex.prepend(1);
        ex.set(4, 122);
        boolean inserted = ex.insert(1, 222);
        System.out.println("revomded index 3 : "+ex.remove(3));
        System.out.println("index get value : "+ex.get(4));
        System.out.println("index get value : "+ex.get(5));

//        int lastItem = ex.removeLast();
//        int firstItem = ex.removeFirst();
//        System.out.println("First Item : "+firstItem + " last item : " +lastItem);
        ex.printList();
    }
}
