// Given an index k, return the kth row of the Pascal's triangle.

// For example, given k = 3,
// Return [1,3,3,1].

// Note:
// Could you optimize your algorithm to use only O(k) extra space?

public class Solution {
    // public List<Integer> getRow(int rowIndex) {
    //     List<Integer> list = new ArrayList<Integer>();

    //     // if(rowIndex == 0){
    //     // 	return list;
    //     // }

    // 	ArrayList<ArrayList<Integer>> inter = generate(rowIndex + 1);
    // 	list = inter.get(inter.size() - 1);
    //     return list;
    // }

    // public ArrayList<ArrayList<Integer>> generate(int numRows) {
    //     ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

    //     if(numRows == 0){
    //     	return list;
    //     }

    //     ArrayList<Integer> tempList = new ArrayList<Integer>();
    //     tempList.add(1);
    //     list.add(tempList);

    //     for(int i = 1; i < numRows; i++){
    //     	tempList = new ArrayList<Integer>();

    //     	for(int j = 0; j <= list.get(list.size() - 1).size(); j++){
    //     		if(j == 0){
    //     			tempList.add(1);
    //     			continue;
    //     		}else if(j == list.get(list.size() - 1).size()){
    //     			tempList.add(1);
    //     			break;
    //     		}

    //     		ArrayList<Integer> last = list.get(list.size() - 1);
    //     		tempList.add(last.get(j) + last.get(j - 1));
    //     	}

    //     	list.add(tempList);
    //     }

    //     return list;
    // }

    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<Integer> rst = new ArrayList<Integer>();
        rowIndex += 1;
        if (rowIndex == 0) {
            return rst;
        }

        rst.add(1);
        for (int i = 1; i < rowIndex; i++) {
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            for (int j = 0; j < i + 1; j++) {
                tmp.add(1);
            }
            tmp.set(0, rst.get(0));
            tmp.set(i, rst.get(i - 1));
            for (int j = 1; j < i; j++) {
                tmp.set(j, rst.get(j - 1) + rst.get(j));
            }
            rst = tmp;
        }
        return rst;
    }
}