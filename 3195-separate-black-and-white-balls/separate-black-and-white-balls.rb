# @param {String} s
# @return {Integer}
def minimum_steps(s)
    res = 0
    zero_count = 0
    
    (s.length-1).downto(0) do |index|
        if (s[index] == '1')
            res += zero_count
        else
            zero_count += 1
        end
    end

    res
end