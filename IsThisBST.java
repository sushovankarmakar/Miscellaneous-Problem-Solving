boolean checkBST(Node root) {
        if(root == null) return false;
        return checkBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean checkBSTUtil(Node root, int lowerLimit, int upperLimit) {
        if(root == null) return true;
        
        if(lowerLimit < root.data && root.data < upperLimit) {
            return checkBSTUtil(root.left, lowerLimit, root.data) && checkBSTUtil(root.right, root.data, upperLimit);
        }
        return false;
    }