// // Memory Limit Exceeded.
// class MinStack {
// 	private class Node {
// 		int val;
// 		Node next;
// 		Node(int val) {
// 			this.val = val;
// 		}
// 	}

// 	Node normNode = null;
// 	Node minNode = null;

//     public void push(int x) {
//         if (normNode == null) {
//         	normNode = new Node(x);
//         	minNode = new Node(x);
//         } else {
//         	Node tempNorm = new Node(x);
//         	tempNorm.next = normNode;
//         	normNode = tempNorm;
//         	Node tempMin;
//         	if (x < minNode.val) {
// 				tempMin = new Node(x);
//     		}else {
//         		tempMin = new Node(minNode.val);
//     		}
//     		tempMin.next = minNode;
//     		minNode = tempMin;
//         }
//     }

//     public void pop() {
//         if (normNode != null) {
//         	normNode = normNode.next;
//         	minNode = minNode.next;
//         }
//     }

//     public int top() {
//         if (normNode != null) {
//         	int val = normNode.val;
//         	return val;
//         } else {
//         	return -1;
//         }
//     }

//     public int getMin() {
//         if (normNode != null) {
//         	int min = minNode.val;
//         	return min;
//         } else {
//         	return -1;
//         }
//     }
// }


// Try to use resizing array.
class MinStack {
    int[] st = new int[20];
    int[] min = new int[20];
    int size = 0;

    private void resize() {
        int currentLen = st.length;
        int newLen = currentLen * 2;
        int[] tempSt = new int[newLen];
        int[] tempMin = new int[newLen];
        copy(st, currentLen, tempSt);
        copy(min, currentLen, tempMin);
        st = tempSt;
        min = tempMin;
    }

    public void copy(int[] A, int len, int[] B) {
        // copy content in A of size len to B.
        for (int i = 0; i < len; i++) {
            B[i] = A[i];
        }
    }


    public void push(int x) {
        if (size == 0) {
            int index = size++;
            st[index] = x;
            min[index] = x;
        } else {
            if (size == st.length - 1) {
                resize();
            }
            int index = size++;
            st[index] = x;
            int lastMin = min[index -1];
            if (x < lastMin) {
                min[index] = x;
            } else {
                min[index] = lastMin;
            }
        }
    }

    public void pop() {
        if (size != 0) {
            size--;
        }
    }

    public int top() {
        if (size != 0) {
            return st[size - 1];
        } else {
            return -1;
        }
    }

    public int getMin() {
        if (size != 0) {
            return min[size - 1];
        } else {
            return - 1;
        }
    }
}
