def infix_to_postfix(infix_expression):
    precedence = {'+': 1, '-': 1, '*': 2, '/': 2, '^': 3}
    output = []
    stack = []
    
    for token in infix_expression:
        if token.isalnum() or token.isnumeric():
            output.append(token)
        elif token == '(':
            stack.append(token)
        elif token == ')':
            while stack and stack[-1] != '(':
                output.append(stack.pop())
            if stack and stack[-1] == '(':
                stack.pop()  # Remove the open parenthesis
            else:
                raise ValueError("Mismatched parentheses")
        else:
            while (stack and stack[-1] != '(' and
                   precedence.get(token, 0) <= precedence.get(stack[-1], 0)):
                output.append(stack.pop())
            stack.append(token)

    while stack:
        if stack[-1] == '(':
            raise ValueError("Mismatched parentheses")
        output.append(stack.pop())

    return ' '.join(output)

def calculate_postfix(postfix_expression):
    stack = []
    for token in postfix_expression:
        if token.isnumeric():
            stack.append(token)
        else:
            operand2 = stack.pop()
            operand1 = stack.pop()
            result = eval(operand1 + token + operand2)
            stack.append(str(result))
    return stack.pop()



# Example usage:

# taking input from user
infix_expression = input("Enter an infix expression: ")
print(infix_to_postfix(infix_expression))





