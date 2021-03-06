package ru.rain.ifmo.teplyakov.parser;

import ru.rain.ifmo.teplyakov.exception.RuntimeErrorException;

import java.util.Map;

public class IfExpression implements TreeNode {

    public IfExpression(TreeNode condition, TreeNode trueBranch, TreeNode falseBranch) {
        this.condition = condition;
        this.trueBranch = trueBranch;
        this.falseBranch = falseBranch;
    }

    @Override
    public Integer evaluate(Map<String, Integer> context) throws RuntimeErrorException {
        return condition.evaluate(context) == 0 ? falseBranch.evaluate(context) : trueBranch.evaluate(context);
    }

    @Override
    public TreeNode[] getChildren() {
        return new TreeNode[]{condition, trueBranch, falseBranch};
    }

    @Override
    public String toString() {
        return "[" + condition.toString() + "]?{" + trueBranch.toString() + "}:{" + falseBranch.toString() + "]";
    }

    private TreeNode condition;
    private TreeNode trueBranch;
    private TreeNode falseBranch;
}
