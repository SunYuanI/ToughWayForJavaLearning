package algorithm;

public class MaxSubSum {
	public int maxSubSum1(int a[]) {
		int maxSum=0;
		for(int i=0;i<a.length;i++) {
			for(int j=i;j<a.length;j++) {
				int thisSum=0;
				for(int k=i;k<=j;k++) {
					thisSum+=a[k];
					if(thisSum>maxSum) {
						maxSum=thisSum;
					}
				}
			}
		}
		return maxSum;
	}
	public int maxSubSum2(int a[]) {
		int maxSum=0;
		for(int i=0;i<a.length;i++) {
			int thisSum=0;
			for(int j=i;j<a.length;j++) {
				thisSum+=a[j];
				if(thisSum>maxSum) {
					maxSum=thisSum;
				}
			}
		}
		return maxSum;
	}
	public int maxSum3(int a[]) {
		return maxSumRec(a,0,a.length-1);
	}
	public int maxSumRec(int a[],int left,int right) {
		if(left==right) {
			if(a[left]>=0) {
				return a[left];
			}else {
				return 0;
			}
		}
		int center=(left+right)/2;
		int maxLeftSum=maxSumRec(a,left,center);
		int maxRightSum=maxSumRec(a, center+1, right);
		int maxLeftSumBorder=0;
		int leftSumBorder=0;
		for(int i=center;i>=left;i--) {
			leftSumBorder+=a[i];
			if(leftSumBorder>maxLeftSumBorder) {
				maxLeftSumBorder=leftSumBorder;
			}
		}
		int maxRightSumBorder=0;
		int rightSumBorder=0;
		for(int i=center+1;i<=right;i++) {
			rightSumBorder+=a[i];
			if(rightSumBorder>maxRightSumBorder) {
				maxRightSumBorder=rightSumBorder;
			}
		}
		return findMax(maxLeftSum,maxRightSum,maxLeftSumBorder+maxRightSumBorder);
	}
	public int findMax(int a,int b,int c) {
		int max=a;
		if(b>max) {
			max=b;
		}
		if(c>max) {
			max=c;
		}
		return max;
	}
	public int maxSum4(int a[]){
		int maxSum=0;
		int thisSum=0;
		for(int i=0;i<a.length;i++) {
			thisSum+=a[i];
			if(thisSum>maxSum) {
				maxSum=thisSum;
			}else {
				if(thisSum<0) {
					thisSum=0;
				}
			}
		}
		return maxSum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
