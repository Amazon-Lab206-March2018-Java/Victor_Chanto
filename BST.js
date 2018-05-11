function BTNode(value) {
    this.val = value;
    this.left = null;
    this.right = null;
}

function BST() {
    this.root = null;

    this.add = function(value) {
        var p = this.root;
        if (p == null) {
            this.root = new BTNode(value);
            return this;
        }
        var node = new BTNode(value);
        while (p != null) {
            if (value <= p.val) {
                if (p.left == null) {
                    p.left = node;
                    return this;
                }
                p = p.left;
            } else if (value > p.val) {
                if (p.right == null) {
                    p.right = node;
                    return this;
                }
                p = p.right;
            }
        }
        return this;
    }

    this.Min = function Min(){
        var min = this.root;
        if (!this.isEmpty()){
            while(min.left){
                min = min.left;
            }
            return min.val;
        }
        return null;
    }

    this.Max = function Max(){
        var max = this.root;
        if (!this.isEmpty()){
            while(max.right){
                max = max.right;
            }
            return max.val;
        }
        return null;
    }

    this.isEmpty= function isEmpty(){
        if (this.root == null){
            return true;
        }
        return false;
    }

    this.contains = function contains(value) {
        var p = this.root;
        while (p){
            if (p.val == value){
                return true;
            } else if (p.val<value){
                p=p.right
            } else{
                p=p.left;
            }
        }
        return false;
    }

    this.print = function() {
        if(!this.root) {
            return console.log('No root found');
        }
        var newline = new BTNode('|');
        var queue = [this.root, newline];
        var string = '';
        while(queue.length) {
          var node = queue.shift();
          string += node.val.toString() + ' ';
          if(node === newline && queue.length) {
            queue.push(newline);
          }
          if(node.left) {
            queue.push(node.left);
          }
          if(node.right) {
            queue.push(node.right);
          }
        }
        console.log(string.slice(0, -2).trim());
    };

    this.printByLevel = function() {
        if(!this.root) {
          return console.log('No root node found');
        }
        var newline = new BTNode('\n');
        var queue = [this.root, newline];
        var string = '';
        while(queue.length) {
          var node = queue.shift();
          string += node.val.toString() + (node.val !== '\n' ? ' ' : '');
          if(node === newline && queue.length) {
            queue.push(newline);
          }
          if(node.left) {
            queue.push(node.left);
          }
          if(node.right) {
            queue.push(node.right);
          }
        }
        console.log(string.trim());
      };
    this.size = function (BSNode = this.root) {
        var left = BSNode.left;
        var right = BSNode.right;
        if (!left && !right) {
            return 1
        } else if (!left && right) {
            return 1 + this.size(right)
        } else if (left && !right) {
            return 1 + this.size(left)
        } else if (left && right) {
            return 1 + this.size(left) + this.size(right)
        }
    };
    this.height = function (node = this.root) {
        if (!node) {
            return 0;
        }
        if (!node.left && !node.right) {
            return 1;
        }
        if (node.left && node.right) {
            if (this.height(node.left) < this.height(node.right)) {
                return 1 + this.height(node.right)
            }
            if (this.height(node.left) == this.height(node.right)) {
                return 1 + (this.height(node.right) + this.height(node.left)) / 2
            }
            if (this.height(node.left) > this.height(node.right)) {
                return 1 + this.height(node.left)
            }
        }
        if (node.left && !node.right) {
            return 1 + this.height(node.left)
        }
        if (node.right && !node.left) {
            return 1 + this.height(node.right)
        }
    }
}

var newBST = new BST();

// newBST.print();

// newBST.add(8);
// newBST.add(10);
// newBST.add(5);
// newBST.add(12);
// newBST.add(8);
// newBST.add(1);
// newBST.add(3);
// newBST.add(4);
// console.log(newBST.Max());
// console.log(newBST.Min());
// console.log(newBST.isEmpty());
// console.log(newBST.contains(18)) ;
// console.log(newBST.height());

// console.log("************************");
// newBST.printByLevel();
// console.log("************************");
// newBST.print();
// console.log("************************");
// console.log(newBST.size()); 

var BSTree = new BST();
var balanceLeft = new BST();
var balanceRight = new BST();
balanceLeft.add(10).add(9).add(8).add(7).add(6).add(5).add(4);
balanceRight.add(0).add(1).add(2).add(3).add(4).add(5).add(6);
BSTree.add(5).add(10).add(4).add(9).add(3).add(15).add(6).add(1).add(5).add(10).add(4).add(9).add(3).add(15).add(6).add(1).add(11).add(7).add(3).add(15).add(6).add(1).add(11).add(7);
console.log("***********size*****************");
console.log(BSTree.size())
console.log("**********height**********************");
console.log(BSTree.height())
// console.log("***********size*****************");
// console.log(balanceLeft.size())
// console.log("**********height**********************");
// console.log(balanceLeft.height())
// console.log("***********size*****************");
// console.log(balanceRight.size())
// console.log("**********height**********************");
// console.log(balanceRight.height())
// console.log("********************************");
console.log("*******************************");
BSTree.printByLevel();