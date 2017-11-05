bigorder(Cust) :-
    order(Cust, _, Quantity),
    Quantity > 100.

notenough(Cust, Part) :-
    part(Part, Partid,_),
    order(Cust, Partid, Q1),
    inventory(Partid, Q2),
    Q2 < Q1.

orderedmore(C1, C2) :-
    order(C1, Part, Q1),
    order(C2, Part, Q2),
    Q1 > Q2.
