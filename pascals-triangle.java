// Given numRows, generate the first numRows of Pascal's triangle.

// For example, given numRows = 5,
// Return

// [
//      [1],
//     [1,1],
//    [1,2,1],
//   [1,3,3,1],
//  [1,4,6,4,1]
// ]

public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        if(numRows == 0){
        	return list;
        }

        ArrayList<Integer> tempList = new ArrayList<Integer>();
        tempList.add(1);
        list.add(tempList);

        for(int i = 1; i < numRows; i++){
        	tempList = new ArrayList<Integer>();

        	for(int j = 0; j <= list.get(list.size() - 1).size(); j++){
        		if(j == 0){
        			tempList.add(1);
        			continue;
        		}else if(j == list.get(list.size() - 1).size()){
        			tempList.add(1);
        			break;
        		}

        		ArrayList<Integer> last = list.get(list.size() - 1);
        		tempList.add(last.get(j) + last.get(j - 1));
        	}

        	list.add(tempList);
        }

        return list;
    }
}
