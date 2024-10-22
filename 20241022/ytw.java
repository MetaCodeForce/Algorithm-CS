private ListNode mergeTwoLists(ListNode listi, ListNode list2) {

    ListNode headNodel = list1;
    ListNode headNode2 = list2;
    ListNode rootNode = null;
    
    if(headNode1 != null && headNode2 != null) {
        if(headNode1.val > headNode2.val) {
            rootNode = headNode2;
            headNode2 = headNode2.next;
        } else{
            rootNode = headNodel;
            headNodel = headNodel.next;
        }
    }
    if(headNode1 == null && headNode2 != null) {
        rootNode = headNode2;
        headNode2 = headNode2.next;
    }    
    if(headNode1 != null && headNode2 == null){
        rootNode = headNode1;
        headNlodel = headNodel.next;
    }
    
    if(rootNode == null) return null;
    
    while(true){
        if(parentNode == null){
            parentNode = rootNode;
        }

        if(headNode1 != null && headNode2 != null) {
            if(headNode1.val > headNode2.val) {
                childNode = headNode2;
                headNode2 = headNode2.next;
            } else{
                childNode = headNodel;
                headNodel = headNodel.next;
            }
        }
        if(headNode1 == null && headNode2 != null) {
            childNode = headNode2;
            headNode2 = headNode2.next;
        }    
        if(headNode1 != null && headNode2 == null){
            childNode = headNode1;
            headNlodel = headNodel.next;
        }
    }
    parentNode.next = new ListNode(childNode.val);
    if(headNodel.next == null && headNode2.next){
        break;
    }
    return rootNode;
}    


