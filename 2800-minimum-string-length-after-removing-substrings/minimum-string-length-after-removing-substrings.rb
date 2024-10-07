# @param {String} s
# @return {Integer}
def min_length(s)
    stack = []
    s.each_char do |ch|
        if ((ch=='B' && stack[-1]=='A') || (ch=='D' && stack[-1]=='C'))
            stack.pop()
        else
            stack.push(ch)
        end
    end

    stack.size
end