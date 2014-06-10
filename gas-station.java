// There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

// You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

// Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

// Note:
// The solution is guaranteed to be unique.

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0; i < gas.length; i++){
        	int tank = gas[i];
        	int stop = gas.length;
        	int j = i;

        	while(stop > 0){
        		if(tank - cost[j] < 0){
        			break;
        		}

        		tank -= cost[j];
        		j = j == gas.length - 1? 0 : j + 1;
        		tank += gas[j];
        		stop--;
        	}

        	if(stop == 0){
        		return i;
        	}
        }
    	return -1;
    }
}