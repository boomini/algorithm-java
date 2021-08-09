package linkedlist;

public class SinglyLinkedListTest {
	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.addLastNode("πÃ¥œ");
		list.addLastNode("»≠¿Ã∆√");
		System.out.println(list.getLastNode());
		System.out.println(list.getNode("πÃ¥œ"));
		list.printList();
		
		list.addFirstNode("∞ıµµ∏Æ");
		list.printList();
		
		list.insertAfterNode(list.getNode("πÃ¥œ"), "±Ë∫∏πŒ");
		list.printList();
		
		Node target = list.getNode("πÃ¥œ");
		System.out.println(list.getPreviousNode(target));
		
		list.deleteNode("∞ıµµ∏Æ");
		list.printList();
	}
}
