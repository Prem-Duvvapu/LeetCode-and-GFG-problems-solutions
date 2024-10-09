# @param {String} s
# @return {Integer}
def min_add_to_make_valid(s)
    stack = []

    s.each_char do |ch|
        if ch == ')' && stack.last == '('
            stack.pop
        else
            stack.push(ch)
        end
    end

    stack.size
end