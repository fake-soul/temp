import sys
import random
 
def ParseGraph(filename):
  """Parse a graph into adjacency list format per programming Q.3
 
     Args:
     - filename: the on-disk graph representation
     Returns:
     (vertices, edges) where
       vertices = [vertex_1, vertex_2, ...]
       edges = [(vertex_1, vertex_2), ...]
  """
  vertices = []
  edges = set([])
 
  for l in open(filename):
    fields = [int(f) for f in l.split()]
    vertex = fields.pop(0)
    incident = [tuple(sorted([vertex, f])) for f in fields]
    vertices.append(vertex)
    edges.update(incident)
 
  return vertices, list(edges)
 
def RandomContraction(vertices, edges):
  while len(vertices) > 2:
    edge = random.choice(edges)
    a, b = edge
    vertices.remove(b)
    new_edges = []
    for e in edges:
      if e == edge:
        continue
      if b in e:
        if e[0] == b:
          other = e[1]
        if e[1] == b:
          other = e[0]
        e = tuple(sorted([a, other]))
      new_edges.append(e)
    edges = new_edges
 
  return vertices, edges
 
vertices, edges = ParseGraph(sys.argv[1])
 
minimum = sys.maxint
for i in range(0, 1000):
  v, e = RandomContraction(vertices[:], edges[:])
  print v, len(e)
  if len(e) < minimum:
    minimum = len(e)
 
print "min cut: %d" % minimum
