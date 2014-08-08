// Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

// You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

// Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

// For the last line of text, it should be left justified and no extra space is inserted between words.

// For example,
// words: ["This", "is", "an", "example", "of", "text", "justification."]
// L: 16.

// Return the formatted lines as:
// [
//    "This    is    an",
//    "example  of text",
//    "justification.  "
// ]
// Note: Each word is guaranteed not to exceed L in length.


public class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<String>();
        // List<String> tempList = new ArrayList<String>();
        if(words.length == 0) return result;
        if(words.length == 1 && words[0] == ""){
            StringBuilder sb = new StringBuilder();
            while(L != 0){
                sb.append(" ");
                L--;
            }
            result.add(sb.toString());
            return result;
        }

        int currentStringLen = 0;
        int currentSpace = 0;
        int start = 0, end = 0;

        for(int i = 0; i < words.length; i++){
            String s = words[i];
            int sLen = s.length();
            if(currentStringLen == 0){
                currentStringLen += sLen;
                currentSpace += 1;
            }else{
                if( currentStringLen + currentSpace + sLen  > L){
                    pack(words, result, start, i, currentStringLen, currentSpace, L);
                    currentStringLen = 0;
                    currentSpace = 0;
                    start = i;
                    i--;
                }else if( currentStringLen + currentSpace + sLen  == L){
                    pack(words, result, start, i + 1, currentStringLen + sLen, currentSpace, L);
                    currentStringLen = 0;
                    currentSpace = 0;
                    start = i + 1;
                }else{
                    currentStringLen += sLen;
                    currentSpace += 1;
                }
            }
        }

        if(currentStringLen > 0){
            pack(words, result, start, words.length, currentStringLen, currentSpace, L);
        }

        return result;
    }

    public void pack(String[] words, List<String> result, int start, int end, int currentStringLen, int currentSpace, int totalLen){ // start is inclusize while end is exclusive
    	int wordsCount = end - start;
        int space = totalLen - currentStringLen;
        StringBuilder sb = new StringBuilder();
        int[] padding = new int[wordsCount - 1];

		if(wordsCount - 1 != 0){
			if(end == words.length){
				 // last line do not need to be justified.

                // something is wrong here: if it is the last line, then the padding count
                // should no longer be wordsCount - 1, it will depend on the total words in
                // last line, and the space they occupy.
                // so you should take account this into it.
                padding = new int[wordsCount];
                for(int i = 0; i < wordsCount - 1; i++){
                    padding[i] = 1;
                    space--;
                }
                padding[wordsCount - 1] = space;
			}else{
				int pad = space / ( wordsCount - 1);
				for(int i = 0; i < padding.length; i++){
					padding[i] = pad;
				}
				if(space % (wordsCount - 1)!= 0){
					int mod = space % (wordsCount - 1);
					for(int i = 0; i < mod; i++){
						padding[i] += 1;
					}
				}
			}
		}else{
            padding = new int[1];
            padding[0] = space;
        }      

		int counter = 0;
        for(int i = start; i < end; i++){
            sb.append(words[i]);
            if(padding.length != 0 && counter < padding.length){
                int tempPad = padding[counter];
                counter++;
                while(tempPad != 0){
                    sb.append(" ");
                    tempPad--;
                }
            }
        }

        result.add(sb.toString());
    }
}