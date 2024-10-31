# @param {Integer[][]} is_connected
# @return {Integer}
def find_circle_num(is_connected)
    n = is_connected.length
    visited = Array.new(n, false)
    res = 0

    (0...n).each do |i|
        unless visited[i]
            res += 1
            dfs(i, visited, is_connected, n)
        end
    end

    res
end

def dfs(currNode, visited, is_connected, n)
    visited[currNode] = true

    (0...n).each do |i|
        if (is_connected[currNode][i]==1 && !visited[i])
            dfs(i, visited, is_connected, n)
        end
    end
end