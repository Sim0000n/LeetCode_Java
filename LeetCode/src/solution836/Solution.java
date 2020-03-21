package solution836;

class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if(rec1[0] >= rec2[0]) {
            if(rec1[0] >= rec2[2])
                return false;
            if(rec1[1] >= rec2[1])  {
                if(rec1[1] >= rec2[3])
                    return false;
            } else {
                if(rec2[1] >= rec1[3])
                    return false;
            }
        } else {
            if(rec2[0] >= rec1[2])
                return false;
            if(rec1[1] >= rec2[1])  {
                if(rec1[1] >= rec2[3])
                    return false;
            } else {
                if(rec2[1] >= rec1[3])
                    return false;
            }
        }
        return true;
    }
}