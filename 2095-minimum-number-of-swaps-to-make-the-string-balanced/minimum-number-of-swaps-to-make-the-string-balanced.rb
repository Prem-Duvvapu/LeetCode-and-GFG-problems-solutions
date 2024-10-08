# @param {String} s
# @return {Integer}
def min_swaps(s)
    stack_size = 0

    s.each_char do |ch|
        if ch == '['
            stack_size += 1
        else
            if stack_size > 0
                stack_size -= 1
            end
        end
    end

    (stack_size + 1)/2
end