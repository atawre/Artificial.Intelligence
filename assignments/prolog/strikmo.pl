digit(1).
digit(2).
digit(3).
digit(4).

solve(A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P) :-
  digit(A), digit(B), digit(C), digit(D), 
  digit(E), digit(F), digit(G), digit(H), 
  digit(I), digit(J), digit(K), digit(L), 
  digit(M), digit(N), digit(O), digit(P), 
  fd_all_different([A,B,C,D]),
  fd_all_different([E,F,G,H]),
  fd_all_different([I,J,K,L]),
  fd_all_different([M,N,O,P]),

  fd_all_different([A,E,I,M]),
  fd_all_different([B,F,J,N]),
  fd_all_different([C,G,K,O]),
  fd_all_different([D,H,L,P]),

  fd_all_different([A,E,I,F]),
  fd_all_different([B,C,D,H]),
  fd_all_different([M,J,G,K]),
  fd_all_different([N,O,P,L]).

