
/*
	Student name and family:Edris Lotfpouri,Aryas Karimi
	Student ID:               9717023152    9717023149
	Semester: Spring 2019
	Lecturer: Amanj Khorramian
 */

import java.util.*;
import java.util.Arrays.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// color: 1=Black/Red , 2=White/Green , 0=null area
class FindTurn {
	FindTurn() {
		Turn.T = (int) (Math.random() * 2 + 1);
		new Turn();
	}
}

class Turn {
	static int T;

	Turn() {
		if (T == 1) {
			Player1.color = 1;
			Player2.color = 2;
			new Player1();
			// new Player2();
		} else {
			Player2.color = 1;
			Player1.color = 2;
			new Player2();
			// new Player1();

		}
	}
}

interface Intdisk {
	static int[][] disk = new int[8][8];
	int[] probableArray = new int[64];

}

class Intializer implements Intdisk {
	static {
		// Bcounter=0;
		disk[3][3] = 2;
		disk[3][4] = 1;
		disk[4][3] = 1;
		disk[4][4] = 2;
	}
}

class Player1 implements Intdisk {
	static int color;
	int pc = 0, p;
	int Bcounter = 0;
	static int[] array = { 0, 0, 0, 0 };

	Player1() {
		Arrays.fill(probableArray, -1);
		// System.arraycopy(disk,0,Undo.disk3,0,Undo.disk3.length);
		if (color == 1) {
			// disk [3][4]
			Outter: for (int i = 0; i < 8; i++) {
				Inner: for (int j = 0; j < 6; j++) {
					if (disk[i][j] == 1) {
						for (int c1 = 1; j + c1 < 8; c1++) {
							if (disk[i][j + c1] == 1)
								continue Outter;
							else if (disk[i][j + c1] == 0)
								continue Outter;
							else if (disk[i][j + c1] == 2) {
								for (int inc = c1 + 1; j + inc < 8; inc++) {
									if (disk[i][j + inc] == 0) {
										probableArray[pc] = i;
										probableArray[pc + 1] = j + inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i][j + inc] == 2)
										continue;
									else if (disk[i][j + inc] == 1)
										break;
								}
							}
						}
					}
				}
			}
		Outter: for (int i = 0; i < 6; i++) {
			Inner: for (int j = 0; j < 8; j++) {
				if (disk[i][j] == 1) {
					for (int c1 = 1; i + c1 < 8; c1++) {
						if (disk[i + c1][j] == 1)
							continue Outter;
						else if (disk[i + c1][j] == 0)
							continue Outter;
						else if (disk[i + c1][j] == 2) {
							for (int inc = c1 + 1; i + inc < 8; inc++) {
								if (disk[i + inc][j] == 0) {
									probableArray[pc] = i + inc;
									probableArray[pc + 1] = j;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i + inc][j] == 2)
									continue;
								else if (disk[i + inc][j] == 1)
									break;
							}
						}
					}
				}
			}
		}
			Outter: for (int i = 0; i < 8; i++) {
				Inner: for (int j = 2; j < 8; j++) {
					if (disk[i][j] == 1) {
						for (int c1 = 1; j - c1 >= 0; c1++) {
							if (disk[i][j - c1] == 1)
								continue Outter;
							else if (disk[i][j - c1] == 0)
								continue Outter;
							else if (disk[i][j - c1] == 2) {
								for (int inc = c1 + 1; j - inc >= 0; inc++) {
									if (disk[i][j - inc] == 0) {
										probableArray[pc] = i;
										probableArray[pc + 1] = j - inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i][j - inc] == 2)
										continue;
									else if (disk[i][j - inc] == 1)
										break;
								}
							}
						}
					}
				}
			}
		Outter: for (int i = 2; i < 8; i++) {
			Inner: for (int j = 0; j < 8; j++) {
				if (disk[i][j] == 1) {
					for (int c1 = 1; i - c1 >= 0; c1++) {
						if (disk[i - c1][j] == 1)
							continue Outter;
						else if (disk[i - c1][j] == 0)
							continue Outter;
						else if (disk[i - c1][j] == 2) {
							for (int inc = c1 + 1; i - inc >= 0; inc++) {
								if (disk[i - inc][j] == 0) {
									probableArray[pc] = i - inc;
									probableArray[pc + 1] = j;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i - inc][j] == 2)
									continue;
								else if (disk[i - inc][j] == 1)
									break;
							}
						}
					}
				}
			}
		}
			Outter: for (int i = 2; i < 8; i++) {
				Inner: for (int j = 0; j < 6; j++) {
					if (disk[i][j] == 1) {
						for (int c1 = 1; j + c1 < 8; c1++) {
							if (disk[i - c1][j + c1] == 1)
								continue Outter;
							else if (disk[i - c1][j + c1] == 0)
								continue Outter;
							else if (disk[i - c1][j + c1] == 2) {
								for (int inc = c1 + 1; j + inc < 8; inc++) {
									if (disk[i - inc][j + inc] == 0) {
										probableArray[pc] = i - inc;
										probableArray[pc + 1] = j + inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i - inc][j + inc] == 2)
										continue;
									else if (disk[i - inc][j + inc] == 1)
										break;
								}
							}
						}
					}
				}
			}
		Outter: for (int i = 0; i < 6; i++) {
			Inner: for (int j = 2; j < 8; j++) {
				if (disk[i][j] == 1) {
					for (int c1 = 1; j - c1 >= 0; c1++) {
						if (disk[i + c1][j - c1] == 1)
							continue Outter;
						else if (disk[i + c1][j - c1] == 0)
							continue Outter;
						else if (disk[i + c1][j - c1] == 2) {
							for (int inc = c1 + 1; j - inc >= 0; inc++) {
								if (disk[i + inc][j - inc] == 0) {
									probableArray[pc] = i + inc;
									probableArray[pc + 1] = j - inc;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i + inc][j - inc] == 2)
									continue;
								else if (disk[i + inc][j - inc] == 1)
									break;
							}
						}
					}
				}
			}
		}
			Outter: for (int i = 0; i < 6; i++) {
				Inner: for (int j = 0; j < 6; j++) {
					if (disk[i][j] == 1) {
						for (int c1 = 1; j + c1 < 8; c1++) {
							if (disk[i + c1][j + c1] == 1)
								continue Outter;
							else if (disk[i + c1][j + c1] == 0)
								continue Outter;
							else if (disk[i + c1][j + c1] == 2) {
								for (int inc = c1 + 1; j + inc < 8; inc++) {
									if (disk[i + inc][j + inc] == 0) {
										probableArray[pc] = i + inc;
										probableArray[pc + 1] = j + inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i + inc][j + inc] == 2)
										continue;
									else if (disk[i + inc][j + inc] == 1)
										break;
								}
							}
						}
					}
				}
			}
		Outter: for (int i = 2; i < 8; i++) {
			Inner: for (int j = 2; j < 8; j++) {
				if (disk[i][j] == 1) {
					for (int c1 = 1; j + c1 >= 0; c1++) {
						if (disk[i - c1][j - c1] == 1)
							continue Outter;
						else if (disk[i - c1][j - c1] == 0)
							continue Outter;
						else if (disk[i - c1][j - c1] == 2) {
							for (int inc = c1 + 1; j - inc >= 0; inc++) {
								if (disk[i - inc][j - inc] == 0) {
									probableArray[pc] = i - inc;
									probableArray[pc + 1] = j - inc;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i - inc][j - inc] == 2)
									continue;
								else if (disk[i - inc][j - inc] == 1)
									break;
							}
						}
					}
				}
			}
		}
		} 
		else {
			Outter: for (int i = 0; i < 8; i++) {
				Inner: for (int j = 0; j < 6; j++) {
					if (disk[i][j] == 2) {
						for (int c1 = 1; j + c1 < 8; c1++) {
							if (disk[i][j + c1] == 2)
								continue Outter;
							else if (disk[i][j + c1] == 0)
								continue Outter;
							else if (disk[i][j + c1] == 1) {
								for (int inc = c1 + 1; j + inc < 8; inc++) {
									if (disk[i][j + inc] == 0) {
										probableArray[pc] = i;
										probableArray[pc + 1] = j + inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i][j + inc] == 1)
										continue;
									else if (disk[i][j + inc] == 2)
										break;
								}

							}

						}
					}
				}
			}
		Outter: for (int i = 0; i < 6; i++) {
			Inner: for (int j = 0; j < 8; j++) {
				if (disk[i][j] == 2) {
					for (int c1 = 1; i + c1 < 8; c1++) {
						if (disk[i + c1][j] == 2)
							continue Outter;
						else if (disk[i + c1][j] == 0)
							continue Outter;
						else if (disk[i + c1][j] == 1) {
							for (int inc = c1 + 1; i + inc < 8; inc++) {
								if (disk[i + inc][j] == 0) {
									probableArray[pc] = i + inc;
									probableArray[pc + 1] = j;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i + inc][j] == 1)
									continue;
								else if (disk[i + inc][j] == 2)
									break;
							}
						}
					}
				}
			}
		}
			Outter: for (int i = 0; i < 8; i++) {
				Inner: for (int j = 2; j < 8; j++) {
					if (disk[i][j] == 2) {
						for (int c1 = 1; j - c1 >= 0; c1++) {
							if (disk[i][j - c1] == 2)
								continue Outter;
							else if (disk[i][j - c1] == 0)
								continue Outter;
							else if (disk[i][j - c1] == 1) {
								for (int inc = c1 + 1; j - inc >= 0; inc++) {
									if (disk[i][j - inc] == 0) {
										probableArray[pc] = i;
										probableArray[pc + 1] = j - inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i][j - inc] == 1)
										continue;
									else if (disk[i][j - inc] == 2)
										break;
								}
							}
						}
					}
				}
			}
		Outter: for (int i = 2; i < 8; i++) {
			Inner: for (int j = 0; j < 8; j++) {
				if (disk[i][j] == 2) {
					for (int c1 = 1; i - c1 >= 0; c1++) {
						if (disk[i - c1][j] == 2)
							continue Outter;
						else if (disk[i - c1][j] == 0)
							continue Outter;
						else if (disk[i - c1][j] == 1) {
							for (int inc = c1 + 1; i - inc >= 0; inc++) {
								if (disk[i - inc][j] == 0) {
									probableArray[pc] = i - inc;
									probableArray[pc + 1] = j;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i - inc][j] == 1)
									continue;
								else if (disk[i - inc][j] == 2)
									break;
							}
						}
					}
				}
			}
		}
			Outter: for (int i = 2; i < 8; i++) {
				Inner: for (int j = 0; j < 6; j++) {
					if (disk[i][j] == 2) {
						for (int c1 = 1; j + c1 < 8; c1++) {
							if (disk[i - c1][j + c1] == 2)
								continue Outter;
							else if (disk[i - c1][j + c1] == 0)
								continue Outter;
							else if (disk[i - c1][j + c1] == 1) {
								for (int inc = c1 + 1; j + inc < 8; inc++) {
									if (disk[i - inc][j + inc] == 0) {
										probableArray[pc] = i - inc;
										probableArray[pc + 1] = j + inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i - inc][j + inc] == 1)
										continue;
									else if (disk[i - inc][j + inc] == 2)
										break;
								}
							}
						}
					}
				}
			}
		Outter: for (int i = 0; i < 6; i++) {
			Inner: for (int j = 2; j < 8; j++) {
				if (disk[i][j] == 2) {
					for (int c1 = 1; j - c1 >= 0; c1++) {
						if (disk[i + c1][j - c1] == 2)
							continue Outter;
						else if (disk[i + c1][j - c1] == 0)
							continue Outter;
						else if (disk[i + c1][j - c1] == 1) {
							for (int inc = c1 + 1; j - inc >= 0; inc++) {
								if (disk[i + inc][j - inc] == 0) {
									probableArray[pc] = i + inc;
									probableArray[pc + 1] = j - inc;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i + inc][j - inc] == 1)
									continue;
								else if (disk[i + inc][j - inc] == 2)
									break;
							}
						}
					}
				}
			}
		}
			Outter: for (int i = 0; i < 6; i++) {
				Inner: for (int j = 0; j < 6; j++) {
					if (disk[i][j] == 2) {
						for (int c1 = 1; j + c1 < 8; c1++) {
							if (disk[i + c1][j + c1] == 2)
								continue Outter;
							else if (disk[i + c1][j + c1] == 0)
								continue Outter;
							else if (disk[i + c1][j + c1] == 1) {
								for (int inc = c1 + 1; j + inc < 8; inc++) {
									if (disk[i + inc][j + inc] == 0) {
										probableArray[pc] = i + inc;
										probableArray[pc + 1] = j + inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i + inc][j + inc] == 1)
										continue;
									else if (disk[i + inc][j + inc] == 2)
										break;
								}
							}
						}
					}
				}
			}
		Outter: for (int i = 2; i < 8; i++) {
			Inner: for (int j = 2; j < 8; j++) {
				if (disk[i][j] == 2) {
					for (int c1 = 1; j + c1 >= 0; c1++) {
						if (disk[i - c1][j - c1] == 2)
							continue Outter;
						else if (disk[i - c1][j - c1] == 0)
							continue Outter;
						else if (disk[i - c1][j - c1] == 1) {
							for (int inc = c1 + 1; j - inc >= 0; inc++) {
								if (disk[i - inc][j - inc] == 0) {
									probableArray[pc] = i - inc;
									probableArray[pc + 1] = j - inc;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i - inc][j - inc] == 1)
									continue;
								else if (disk[i - inc][j - inc] == 2)
									break;
							}
						}
					}
				}
			}
		}
		}
		if (probableArray[0] == -1)
			new Player2();

		/*
		 * final JLabel[][] labels = new JLabel[8][8]; MouseListener ml = new
		 * MouseAdapter() { public void mousePressed(MouseEvent me) { Object src
		 * = me.getSource(); int x = -1; int y = -1; for (int i = 0; i <
		 * labels.length; i++) { for (int j = 0; j < labels[i].length; j++) { if
		 * (src == labels[i][j]) { x = i; y = j; break; } } if (x >= 0) { break;
		 * } } if (x > 0) { Color c=MainBoard.ML.label.getForeground();
		 * if(color==1) MainBoard.ML.label.setForeground(Color.black); else
		 * MainBoard.ML.label.setForeground(Color.white); new Play(x,y,color);
		 * new Player2(); } else { System.out.println("Wrong choice"); } } };
		 * for (int row = 0; row < 8; row++) { for (int col = 0; col < 8; col++)
		 * { labels[row][col] = new JLabel(row + "," + col);
		 * labels[row][col].addMouseListener(ml); } }
		 */

		p = probableArray[0];
		new Ml1(p);
		//if (Bcounter == 0) {
		//	new ButtonMaker();
			//Bcounter++;
		//}
		new ButtonMaker(probableArray, array[0], array[1], Player1.color);

	}
}
/*
 * class ML1 implements MouseListener{ int x,y; ML1(int x,int y){
 * MainBoard.ML.label=MainBoard.disk1[x][y]; this.x=x; this.y=y; } public void
 * mouseClicked(MouseEvent e){ Color c=MainBoard.ML.label.getForeground();
 * if(color==1) MainBoard.ML.label.setForeground(Color.black); else
 * MainBoard.ML.label.setForeground(Color.white); new Play(x,y,color); new
 * Player2(); } public void mouseEntered(MouseEvent e) {} public void
 * mouseExited(MouseEvent e) {} public void mousePressed(MouseEvent e) {} public
 * void mouseReleased(MouseEvent e) {} } }
 */

////////////////////////////////////////////////////////////////////

class Player2 implements Intdisk {
	static int color;
	int pc = 0, p;
	int Bcounter = 0;
	static int[] array = { 0, 0, 0, 0 };

	Player2() {
		Arrays.fill(probableArray, -1);
		if (color == 1) {
			Outter: for (int i = 0; i < 8; i++) {
				Inner: for (int j = 0; j < 6; j++) {
					if (disk[i][j] == 1) {
						for (int c1 = 1; j + c1 < 8; c1++) {
							if (disk[i][j + c1] == 1)
								continue Outter;
							else if (disk[i][j + c1] == 0)
								continue Outter;
							else if (disk[i][j + c1] == 2) {
								for (int inc = c1 + 1; j + inc < 8; inc++) {
									if (disk[i][j + inc] == 0) {
										probableArray[pc] = i;
										probableArray[pc + 1] = j + inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i][j + inc] == 2)
										continue;
									else if (disk[i][j + inc] == 1)
										break;
								}

							}

						}
					}
				}
			}
		Outter: for (int i = 0; i < 6; i++) {
			Inner: for (int j = 0; j < 8; j++) {
				if (disk[i][j] == 1) {
					for (int c1 = 1; i + c1 < 8; c1++) {
						if (disk[i + c1][j] == 1)
							continue Outter;
						else if (disk[i + c1][j] == 0)
							continue Outter;
						else if (disk[i + c1][j] == 2) {
							for (int inc = c1 + 1; i + inc < 8; inc++) {
								if (disk[i + inc][j] == 0) {
									probableArray[pc] = i + inc;
									probableArray[pc + 1] = j;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i + inc][j] == 2)
									continue;
								else if (disk[i + inc][j] == 1)
									break;
							}
						}
					}
				}
			}
		}
			Outter: for (int i = 0; i < 8; i++) {
				Inner: for (int j = 2; j < 8; j++) {
					if (disk[i][j] == 1) {
						for (int c1 = 1; j - c1 >= 0; c1++) {
							if (disk[i][j - c1] == 1)
								continue Outter;
							else if (disk[i][j - c1] == 0)
								continue Outter;
							else if (disk[i][j - c1] == 2) {
								for (int inc = c1 + 1; j - inc >= 0; inc++) {
									if (disk[i][j - inc] == 0) {
										probableArray[pc] = i;
										probableArray[pc + 1] = j - inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i][j - inc] == 2)
										continue;
									else if (disk[i][j - inc] == 1)
										break;
								}
							}
						}
					}
				}
			}
		Outter: for (int i = 2; i < 8; i++) {
			Inner: for (int j = 0; j < 8; j++) {
				if (disk[i][j] == 1) {
					for (int c1 = 1; i - c1 >= 0; c1++) {
						if (disk[i - c1][j] == 1)
							continue Outter;
						else if (disk[i - c1][j] == 0)
							continue Outter;
						else if (disk[i - c1][j] == 2) {
							for (int inc = c1 + 1; i - inc >= 0; inc++) {
								if (disk[i - inc][j] == 0) {
									probableArray[pc] = i - inc;
									probableArray[pc + 1] = j;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i - inc][j] == 2)
									continue;
								else if (disk[i - inc][j] == 1)
									break;
							}
						}
					}
				}
			}
		}
			Outter: for (int i = 2; i < 8; i++) {
				Inner: for (int j = 0; j < 6; j++) {
					if (disk[i][j] == 1) {
						for (int c1 = 1; j + c1 < 8; c1++) {
							if (disk[i - c1][j + c1] == 1)
								continue Outter;
							else if (disk[i - c1][j + c1] == 0)
								continue Outter;
							else if (disk[i - c1][j + c1] == 2) {
								for (int inc = c1 + 1; j + inc < 8; inc++) {
									if (disk[i - inc][j + inc] == 0) {
										probableArray[pc] = i - inc;
										probableArray[pc + 1] = j + inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i - inc][j + inc] == 2)
										continue;
									else if (disk[i - inc][j + inc] == 1)
										break;
								}
							}
						}
					}
				}
			}
		Outter: for (int i = 0; i < 6; i++) {
			Inner: for (int j = 2; j < 8; j++) {
				if (disk[i][j] == 1) {
					for (int c1 = 1; j - c1 >= 0; c1++) {
						if (disk[i + c1][j - c1] == 1)
							continue Outter;
						else if (disk[i + c1][j - c1] == 0)
							continue Outter;
						else if (disk[i + c1][j - c1] == 2) {
							for (int inc = c1 + 1; j - inc >= 0; inc++) {
								if (disk[i + inc][j - inc] == 0) {
									probableArray[pc] = i + inc;
									probableArray[pc + 1] = j - inc;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i + inc][j - inc] == 2)
									continue;
								else if (disk[i + inc][j - inc] == 1)
									break;
							}
						}
					}
				}
			}
		}
			Outter: for (int i = 0; i < 6; i++) {
				Inner: for (int j = 0; j < 6; j++) {
					if (disk[i][j] == 1) {
						for (int c1 = 1; j + c1 < 8; c1++) {
							if (disk[i + c1][j + c1] == 1)
								continue Outter;
							else if (disk[i + c1][j + c1] == 0)
								continue Outter;
							else if (disk[i + c1][j + c1] == 2) {
								for (int inc = c1 + 1; j + inc < 8; inc++) {
									if (disk[i + inc][j + inc] == 0) {
										probableArray[pc] = i + inc;
										probableArray[pc + 1] = j + inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i + inc][j + inc] == 2)
										continue;
									else if (disk[i + inc][j + inc] == 1)
										break;
								}
							}
						}
					}
				}
			}
		Outter: for (int i = 2; i < 8; i++) {
			Inner: for (int j = 2; j < 8; j++) {
				if (disk[i][j] == 1) {
					for (int c1 = 1; j + c1 >= 0; c1++) {
						if (disk[i - c1][j - c1] == 1)
							continue Outter;
						else if (disk[i - c1][j - c1] == 0)
							continue Outter;
						else if (disk[i - c1][j - c1] == 2) {
							for (int inc = c1 + 1; j - inc >= 0; inc++) {
								if (disk[i - inc][j - inc] == 0) {
									probableArray[pc] = i - inc;
									probableArray[pc + 1] = j - inc;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i - inc][j - inc] == 2)
									continue;
								else if (disk[i - inc][j - inc] == 1)
									break;
							}
						}
					}
				}
			}
		}
		} 
		else {
			Outter: for (int i = 0; i < 8; i++) {
				Inner: for (int j = 0; j < 6; j++) {
					if (disk[i][j] == 2) {
						for (int c1 = 1; j + c1 < 8; c1++) {
							if (disk[i][j + c1] == 2)
								continue Outter;
							else if (disk[i][j + c1] == 0)
								continue Outter;
							else if (disk[i][j + c1] == 1) {
								for (int inc = c1 + 1; j + inc < 8; inc++) {
									if (disk[i][j + inc] == 0) {
										probableArray[pc] = i;
										probableArray[pc + 1] = j + inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i][j + inc] == 1)
										continue;
									else if (disk[i][j + inc] == 2)
										break;
								}

							}

						}
					}
				}
			}
		Outter: for (int i = 0; i < 6; i++) {
			Inner: for (int j = 0; j < 8; j++) {
				if (disk[i][j] == 2) {
					for (int c1 = 1; i + c1 < 8; c1++) {
						if (disk[i + c1][j] == 2)
							continue Outter;
						else if (disk[i + c1][j] == 0)
							continue Outter;
						else if (disk[i + c1][j] == 1) {
							for (int inc = c1 + 1; i + inc < 8; inc++) {
								if (disk[i + inc][j] == 0) {
									probableArray[pc] = i + inc;
									probableArray[pc + 1] = j;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i + inc][j] == 1)
									continue;
								else if (disk[i + inc][j] == 2)
									break;
							}
						}
					}
				}
			}
		}
			Outter: for (int i = 0; i < 8; i++) {
				Inner: for (int j = 2; j < 8; j++) {
					if (disk[i][j] == 2) {
						for (int c1 = 1; j - c1 >= 0; c1++) {
							if (disk[i][j - c1] == 2)
								continue Outter;
							else if (disk[i][j - c1] == 0)
								continue Outter;
							else if (disk[i][j - c1] == 1) {
								for (int inc = c1 + 1; j - inc >= 0; inc++) {
									if (disk[i][j - inc] == 0) {
										probableArray[pc] = i;
										probableArray[pc + 1] = j - inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i][j - inc] == 1)
										continue;
									else if (disk[i][j - inc] == 2)
										break;
								}
							}
						}
					}
				}
			}
		Outter: for (int i = 2; i < 8; i++) {
			Inner: for (int j = 0; j < 8; j++) {
				if (disk[i][j] == 2) {
					for (int c1 = 1; i - c1 >= 0; c1++) {
						if (disk[i - c1][j] == 2)
							continue Outter;
						else if (disk[i - c1][j] == 0)
							continue Outter;
						else if (disk[i - c1][j] == 1) {
							for (int inc = c1 + 1; i - inc >= 0; inc++) {
								if (disk[i - inc][j] == 0) {
									probableArray[pc] = i - inc;
									probableArray[pc + 1] = j;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i - inc][j] == 1)
									continue;
								else if (disk[i - inc][j] == 2)
									break;
							}
						}
					}
				}
			}
		}
			Outter: for (int i = 2; i < 8; i++) {
				Inner: for (int j = 0; j < 6; j++) {
					if (disk[i][j] == 2) {
						for (int c1 = 1; j + c1 < 8; c1++) {
							if (disk[i - c1][j + c1] == 2)
								continue Outter;
							else if (disk[i - c1][j + c1] == 0)
								continue Outter;
							else if (disk[i - c1][j + c1] == 1) {
								for (int inc = c1 + 1; j + inc < 8; inc++) {
									if (disk[i - inc][j + inc] == 0) {
										probableArray[pc] = i - inc;
										probableArray[pc + 1] = j + inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i - inc][j + inc] == 1)
										continue;
									else if (disk[i - inc][j + inc] == 2)
										break;
								}
							}
						}
					}
				}
			}
		Outter: for (int i = 0; i < 6; i++) {
			Inner: for (int j = 2; j < 8; j++) {
				if (disk[i][j] == 2) {
					for (int c1 = 1; j - c1 >= 0; c1++) {
						if (disk[i + c1][j - c1] == 2)
							continue Outter;
						else if (disk[i + c1][j - c1] == 0)
							continue Outter;
						else if (disk[i + c1][j - c1] == 1) {
							for (int inc = c1 + 1; j - inc >= 0; inc++) {
								if (disk[i + inc][j - inc] == 0) {
									probableArray[pc] = i + inc;
									probableArray[pc + 1] = j - inc;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i + inc][j - inc] == 1)
									continue;
								else if (disk[i + inc][j - inc] == 2)
									break;
							}
						}
					}
				}
			}
		}
			Outter: for (int i = 0; i < 6; i++) {
				Inner: for (int j = 0; j < 6; j++) {
					if (disk[i][j] == 2) {
						for (int c1 = 1; j + c1 < 8; c1++) {
							if (disk[i + c1][j + c1] == 2)
								continue Outter;
							else if (disk[i + c1][j + c1] == 0)
								continue Outter;
							else if (disk[i + c1][j + c1] == 1) {
								for (int inc = c1 + 1; j + inc < 8; inc++) {
									if (disk[i + inc][j + inc] == 0) {
										probableArray[pc] = i + inc;
										probableArray[pc + 1] = j + inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i + inc][j + inc] == 1)
										continue;
									else if (disk[i + inc][j + inc] == 2)
										break;
								}
							}
						}
					}
				}
			}
		Outter: for (int i = 2; i < 8; i++) {
			Inner: for (int j = 2; j < 8; j++) {
				if (disk[i][j] == 2) {
					for (int c1 = 1; j + c1 >= 0; c1++) {
						if (disk[i - c1][j - c1] == 2)
							continue Outter;
						else if (disk[i - c1][j - c1] == 0)
							continue Outter;
						else if (disk[i - c1][j - c1] == 1) {
							for (int inc = c1 + 1; j - inc >= 0; inc++) {
								if (disk[i - inc][j - inc] == 0) {
									probableArray[pc] = i - inc;
									probableArray[pc + 1] = j - inc;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i - inc][j - inc] == 1)
									continue;
								else if (disk[i - inc][j - inc] == 2)
									break;
							}
						}
					}
				}
			}
		}
		}
		if (probableArray[0] == -1)
			new Player1();

		p = probableArray[0];
		new Ml2(p);
		//if (Bcounter == 0) {
			//new ButtonMaker();
			//Bcounter++;
		//}
		new ButtonMaker(probableArray, array[0], array[1], Player2.color);
	}
}

class Ml1 extends MouseAdapter {
	int p;
	MouseListener ml = new MouseAdapter() {
		public void mousePressed(MouseEvent me) {
			Object src = me.getSource();
			int x = -1;
			int y = -1;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (src == MainBoard.disk1[i][j]) {
						x = i;
						y = j;
						break;
					}
				}
				if (x >= 0) {
					break;
				}
			}
			if (p == -1) {
				JOptionPane.showMessageDialog(null, "Wrong Choice");
			}
			if (x >= 0) {
				for (int i = 0; i < 4; i++) {
					if (Player1.array[i] == 0) {
						Player1.array[i] = x;
						Player1.array[i + 1] = y;
						break;
					}
				}
				new Play(x, y, Player1.color);
				new Player2();
			}
		}
	};

	Ml1(int probable) {
		p = probable;
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				MainBoard.disk1[row][col].addMouseListener(ml);
			}
		}
		new ShowTurn(1);
		new ShowTurn('c');
	}
}

class Ml2 extends MouseAdapter {
	int p;
	MouseListener ml = new MouseAdapter() {
		public void mousePressed(MouseEvent me) {
			Object src = me.getSource();
			int x = -1;
			int y = -1;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (src == MainBoard.disk1[i][j]) {
						x = i;
						y = j;
						break;
					}
				}
				if (x >= 0) {
					break;
				}
			}
			if (p == -1) {
				JOptionPane.showMessageDialog(null, "Wrong Choice");
			}
			if (x >= 0) {
				for (int i = 0; i < 4; i++) {
					if (Player2.array[i] == 0) {
						Player2.array[i] = x;
						Player2.array[i + 1] = y;
						break;
					}
				}
				new Play(x, y, Player2.color);
				new Player1();
			}
		}
	};

	Ml2(int probable) {
		p = probable;
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				MainBoard.disk1[row][col].addMouseListener(ml);
			}
		}
		new ShowTurn('c');
		new ShowTurn(1);
	}
}

/*
 * class ML2 implements MouseListener{ int x,y; ML2(int x,int y){
 * MainBoard.ML.label=MainBoard.disk1[x][y]; this.x=x; this.y=y; } public void
 * mouseClicked(MouseEvent e){ Color c=MainBoard.ML.label.getForeground();
 * if(color==1) MainBoard.ML.label.setForeground(Color.black); else
 * MainBoard.ML.label.setForeground(Color.white); new Play(x,y,color); new
 * Player1(); } public void mouseEntered(MouseEvent e) {} public void
 * mouseExited(MouseEvent e) {} public void mousePressed(MouseEvent e) {} public
 * void mouseReleased(MouseEvent e) {} } }
 */
class Play implements Intdisk {
	boolean flag = false;
	int counter = 0;
	static int level = 1;

	Play(int x, int y, int color) {
		// for(int z:probableArray){
		// if(x==z&&y==z+1){
		flag = true;
		if (color == 1) {
			// System.arraycopy(disk,0,Undo.disk3,0,Undo.disk3.length);
			if (y != 6 && y != 7) {
				for (int c1 = 1; y + c1 < 8; c1++) {
					if (disk[x][y + c1] == 1)
						break;
					else if (disk[x][y + c1] == 0)
						break;
					else if (disk[x][y + c1] == 2) {
						for (int inc = c1 + 1; y + inc < 8; inc++) {
							if (disk[x][y + inc] == 1) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x][y+(c1+i)]=disk[x][y+(c1+i)];
									disk[x][y + (c1 + i)] = 1;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 1;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x][y + inc] == 2) {
								counter++;
								continue;
							} else if (disk[x][y + inc] == 0)
								break;
						}
					}
				}
			}
			if (x != 6 && x != 7) {
				for (int c1 = 1; x + c1 < 8; c1++) {
					if (disk[x + c1][y] == 1)
						break;
					else if (disk[x + c1][y] == 0)
						break;
					else if (disk[x + c1][y] == 2) {
						for (int inc = c1 + 1; x + inc < 8; inc++) {
							if (disk[x + inc][y] == 1) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x+(c1+i)][y]=disk[x+(c1+i)][y];
									disk[x + (c1 + i)][y] = 1;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 1;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x + inc][y] == 2) {
								counter++;
								continue;
							} else if (disk[x + inc][y] == 0)
								break;
						}
					}
				}
			}
			if (y != 0 && y != 1) {
				for (int c1 = 1; y - c1 >= 0; c1++) {
					if (disk[x][y - c1] == 1)
						break;
					else if (disk[x][y - c1] == 0)
						break;
					else if (disk[x][y - c1] == 2) {
						for (int inc = c1 + 1; y - inc >= 0; inc++) {
							if (disk[x][y - inc] == 1) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x][y-(c1-i)]=disk[x][y-(c1-i)];
									disk[x][y - (c1 - i)] = 1;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 1;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x][y - inc] == 2) {
								counter++;
								continue;
							} else if (disk[x][y - inc] == 0)
								break;
						}
					}
				}
			}
			if (x != 0 && x != 1) {
				for (int c1 = 1; x - c1 >= 0; c1++) {
					if (disk[x - c1][y] == 1)
						break;
					else if (disk[x - c1][y] == 0)
						break;
					else if (disk[x - c1][y] == 2) {
						for (int inc = c1 + 1; x - inc >= 0; inc++) {
							if (disk[x - inc][y] == 1) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x-(c1-i)][y]=disk[x-(c1-i)][y];
									disk[x - (c1 - i)][y] = 1;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 1;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x - inc][y] == 2) {
								counter++;
								continue;
							} else if (disk[x - inc][y] == 0)
								break;
						}
					}
				}
			}
			if (y != 6 && y != 7 && x != 1) {
				for (int c1 = 1; y + c1 < 8; c1++) {
					if (disk[x - c1][y + c1] == 1)
						break;
					else if (disk[x - c1][y + c1] == 0)
						break;
					else if (disk[x - c1][y + c1] == 2) {
						for (int inc = c1 + 1; y + inc < 8; inc++) {
							if (disk[x - inc][y + inc] == 1) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x-(c1-i)][y+(c1+i)]=disk[x-(c1-i)][y+(c1+i)];
									disk[x - (c1 - i)][y + (c1 + i)] = 1;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 1;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x - inc][y + inc] == 2) {
								counter++;
								continue;
							} else if (disk[x - inc][y + inc] == 0)
								break;
						}
					}
				}
			}
			if (y != 0 && y != 1 && x != 6) {
				for (int c1 = 1; y - c1 >= 0; c1++) {
					if (disk[x + c1][y - c1] == 1)
						break;
					else if (disk[x + c1][y - c1] == 0)
						break;
					else if (disk[x + c1][y - c1] == 2) {
						for (int inc = c1 + 1; y - inc >= 0; inc++) {
							if (disk[x + inc][y - inc] == 1) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x+(c1+i)][y-(c1-i)]=disk[x+(c1+i)][y-(c1-i)];
									disk[x + (c1 + i)][y - (c1 - i)] = 1;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 1;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x + inc][y - inc] == 2) {
								counter++;
								continue;
							} else if (disk[x + inc][y - inc] == 0)
								break;
						}
					}
				}
			}
			if (y != 6 && y != 7 && x != 6) {
				for (int c1 = 1; y + c1 < 8; c1++) {
					if (disk[x + c1][y + c1] == 1)
						break;
					else if (disk[x + c1][y + c1] == 0)
						break;
					else if (disk[x + c1][y + c1] == 2) {
						for (int inc = c1 + 1; y + inc < 8; inc++) {
							if (disk[x + inc][y + inc] == 1) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x+(c1+i)][y+(c1+i)]=disk[x+(c1+i)][y+(c1+i)];
									disk[x + (c1 + i)][y + (c1 + i)] = 1;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 1;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x + inc][y + inc] == 2) {
								counter++;
								continue;
							} else if (disk[x + inc][y + inc] == 0)
								break;
						}
					}
				}
			}
			if (y != 0 && y != 1 && x != 1) {
				for (int c1 = 1; y + c1 >= 0; c1++) {
					if (disk[x - c1][y - c1] == 1)
						break;
					else if (disk[x - c1][y - c1] == 0)
						break;
					else if (disk[x - c1][y - c1] == 2) {
						for (int inc = c1 + 1; y - inc >= 0; inc++) {
							if (disk[x - inc][y - inc] == 1) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x-(c1-i)][y-(c1-i)]=disk[x-(c1-i)][y-(c1-i)];
									disk[x - (c1 - i)][y - (c1 - i)] = 1;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 1;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x - inc][y - inc] == 2) {
								counter++;
								continue;
							} else if (disk[x - inc][y - inc] == 0)
								break;
						}
					}
				}
			}
		}
		// if the color is white
		else {
			// System.arraycopy(disk,0,Undo.disk3,0,Undo.disk3.length);
			if (y != 6 && y != 7) {
				for (int c1 = 1; y + c1 < 8; c1++) {
					if (disk[x][y + c1] == 2)
						break;
					else if (disk[x][y + c1] == 0)
						break;
					else if (disk[x][y + c1] == 1) {
						for (int inc = c1 + 1; y + inc < 8; inc++) {
							if (disk[x][y + inc] == 2) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x][y+(c1+i)]=disk[x][y+(c1+i)];
									disk[x][y + (c1 + i)] = 2;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 2;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x][y + inc] == 1) {
								counter++;
								continue;
							} else if (disk[x][y + inc] == 0)
								break;
						}
					}
				}
			}
			if (x != 6 && x != 7) {
				for (int c1 = 1; x + c1 < 8; c1++) {
					if (disk[x + c1][y] == 2)
						break;
					else if (disk[x + c1][y] == 0)
						break;
					else if (disk[x + c1][y] == 1) {
						for (int inc = c1 + 1; x + inc < 8; inc++) {
							if (disk[x + inc][y] == 2) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x+(c1+i)][y]=disk[x+(c1+i)][y];
									disk[x + (c1 + i)][y] = 2;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 2;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x + inc][y] == 1) {
								counter++;
								continue;
							} else if (disk[x + inc][y] == 0)
								break;
						}
					}
				}
			}
			if (y != 0 && y != 1) {
				for (int c1 = 1; y - c1 >= 0; c1++) {
					if (disk[x][y - c1] == 2)
						break;
					else if (disk[x][y - c1] == 0)
						break;
					else if (disk[x][y - c1] == 1) {
						for (int inc = c1 + 1; y - inc >= 0; inc++) {
							if (disk[x][y - inc] == 2) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x][y-(c1-i)]=disk[x][y-(c1-i)];
									disk[x][y - (c1 - i)] = 2;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 2;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x][y - inc] == 1) {
								counter++;
								continue;
							} else if (disk[x][y - inc] == 0)
								break;
						}
					}
				}
			}
			if (x != 0 && x != 1) {
				for (int c1 = 1; x - c1 >= 0; c1++) {
					if (disk[x - c1][y] == 2)
						break;
					else if (disk[x - c1][y] == 0)
						break;
					else if (disk[x - c1][y] == 1) {
						for (int inc = c1 + 1; x - inc >= 0; inc++) {
							if (disk[x - inc][y] == 2) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x-(c1-i)][y]=disk[x-(c1-i)][y];
									disk[x - (c1 - i)][y] = 2;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 2;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x - inc][y] == 1) {
								counter++;
								continue;
							} else if (disk[x - inc][y] == 0)
								break;
						}
					}
				}
			}
			if (y != 6 && y != 7 && x != 1) {
				for (int c1 = 1; y + c1 < 8; c1++) {
					if (disk[x - c1][y + c1] == 2)
						break;
					else if (disk[x - c1][y + c1] == 0)
						break;
					else if (disk[x - c1][y + c1] == 1) {
						for (int inc = c1 + 1; y + inc < 8; inc++) {
							if (disk[x - inc][y + inc] == 2) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x-(c1-i)][y+(c1+i)]=disk[x-(c1-i)][y+(c1+i)];
									disk[x - (c1 - i)][y + (c1 + i)] = 2;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 2;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x - inc][y + inc] == 1) {
								counter++;
								continue;
							} else if (disk[x - inc][y + inc] == 0)
								break;
						}
					}
				}
			}
			if (y != 0 && y != 1 && x != 6) {
				for (int c1 = 1; y - c1 >= 0; c1++) {
					if (disk[x + c1][y - c1] == 2)
						break;
					else if (disk[x + c1][y - c1] == 0)
						break;
					else if (disk[x + c1][y - c1] == 1) {
						for (int inc = c1 + 1; y - inc >= 0; inc++) {
							if (disk[x + inc][y - inc] == 2) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x+(c1+i)][y-(c1-i)]=disk[x+(c1+i)][y-(c1-i)];
									disk[x + (c1 + i)][y - (c1 - i)] = 2;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 2;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x + inc][y - inc] == 1) {
								counter++;
								continue;
							} else if (disk[x + inc][y - inc] == 0)
								break;
						}
					}
				}
			}
			if (y != 6 && y != 7 && x != 6) {
				for (int c1 = 1; y + c1 < 8; c1++) {
					if (disk[x + c1][y + c1] == 2)
						break;
					else if (disk[x + c1][y + c1] == 0)
						break;
					else if (disk[x + c1][y + c1] == 1) {
						for (int inc = c1 + 1; y + inc < 8; inc++) {
							if (disk[x + inc][y + inc] == 2) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x+(c1+i)][y+(c1+i)]=disk[x+(c1+i)][y+(c1+i)];
									disk[x + (c1 + i)][y + (c1 + i)] = 2;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 2;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x + inc][y + inc] == 1) {
								counter++;
								continue;
							} else if (disk[x + inc][y + inc] == 0)
								break;
						}
					}
				}
			}
			if (y != 0 && y != 1 && x != 1) {
				for (int c1 = 1; y + c1 >= 0; c1++) {
					if (disk[x - c1][y - c1] == 2)
						break;
					else if (disk[x - c1][y - c1] == 0)
						break;
					else if (disk[x - c1][y - c1] == 1) {
						for (int inc = c1 + 1; y - inc >= 0; inc++) {
							if (disk[x - inc][y - inc] == 2) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x-(c1-i)][y-(c1-i)]=disk[x-(c1-i)][y-(c1-i)];
									disk[x - (c1 - i)][y - (c1 - i)] = 2;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 2;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x - inc][y - inc] == 1) {
								counter++;
								continue;
							} else if (disk[x - inc][y - inc] == 0)
								break;
						}
					}
				}
			}
		}
		// }
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (disk[i][j] == 1)
					MainBoard.disk1[i][j].setForeground(Color.black);
				else if (disk[i][j] == 2)
					MainBoard.disk1[i][j].setForeground(Color.white);
			}
		}

		new Counter(level);
		// if(flag==false)
		// JOptionPane.showMessageDialog(null,"Wrong Choice,Select a appropriate
		// one");
		// break;
		// }
	}
}

class Player1Yellow implements Intdisk {
	static int color;
	int pc = 0, p;
	int Bcounter = 0;
	static int[] array = { 0, 0, 0, 0 };

	Player1Yellow() {
		Arrays.fill(probableArray, -1);
		// System.arraycopy(disk,0,Undo.disk3,0,Undo.disk3.length);
		if (Player1.color == 1) {
			// disk [3][4]
			Outter: for (int i = 0; i < 8; i++) {
				Inner: for (int j = 0; j < 6; j++) {
					if (disk[i][j] == 1) {
						for (int c1 = 1; j + c1 < 8; c1++) {
							if (disk[i][j + c1] == 1)
								continue Outter;
							else if (disk[i][j + c1] == 0)
								continue Outter;
							else if (disk[i][j + c1] == 2) {
								for (int inc = c1 + 1; j + inc < 8; inc++) {
									if (disk[i][j + inc] == 0) {
										probableArray[pc] = i;
										probableArray[pc + 1] = j + inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i][j + inc] == 2)
										continue;
									else if (disk[i][j + inc] == 1)
										break;
								}
							}
						}
					}
				}
			}
		Outter: for (int i = 0; i < 6; i++) {
			Inner: for (int j = 0; j < 8; j++) {
				if (disk[i][j] == 1) {
					for (int c1 = 1; i + c1 < 8; c1++) {
						if (disk[i + c1][j] == 1)
							continue Outter;
						else if (disk[i + c1][j] == 0)
							continue Outter;
						else if (disk[i + c1][j] == 2) {
							for (int inc = c1 + 1; i + inc < 8; inc++) {
								if (disk[i + inc][j] == 0) {
									probableArray[pc] = i + inc;
									probableArray[pc + 1] = j;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i + inc][j] == 2)
									continue;
								else if (disk[i + inc][j] == 1)
									break;
							}
						}
					}
				}
			}
		}
			Outter: for (int i = 0; i < 8; i++) {
				Inner: for (int j = 2; j < 8; j++) {
					if (disk[i][j] == 1) {
						for (int c1 = 1; j - c1 >= 0; c1++) {
							if (disk[i][j - c1] == 1)
								continue Outter;
							else if (disk[i][j - c1] == 0)
								continue Outter;
							else if (disk[i][j - c1] == 2) {
								for (int inc = c1 + 1; j - inc >= 0; inc++) {
									if (disk[i][j - inc] == 0) {
										probableArray[pc] = i;
										probableArray[pc + 1] = j - inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i][j - inc] == 2)
										continue;
									else if (disk[i][j - inc] == 1)
										break;
								}
							}
						}
					}
				}
			}
		Outter: for (int i = 2; i < 8; i++) {
			Inner: for (int j = 0; j < 8; j++) {
				if (disk[i][j] == 1) {
					for (int c1 = 1; i - c1 >= 0; c1++) {
						if (disk[i - c1][j] == 1)
							continue Outter;
						else if (disk[i - c1][j] == 0)
							continue Outter;
						else if (disk[i - c1][j] == 2) {
							for (int inc = c1 + 1; i - inc >= 0; inc++) {
								if (disk[i - inc][j] == 0) {
									probableArray[pc] = i - inc;
									probableArray[pc + 1] = j;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i - inc][j] == 2)
									continue;
								else if (disk[i - inc][j] == 1)
									break;
							}
						}
					}
				}
			}
		}
			Outter: for (int i = 2; i < 8; i++) {
				Inner: for (int j = 0; j < 6; j++) {
					if (disk[i][j] == 1) {
						for (int c1 = 1; j + c1 < 8; c1++) {
							if (disk[i - c1][j + c1] == 1)
								continue Outter;
							else if (disk[i - c1][j + c1] == 0)
								continue Outter;
							else if (disk[i - c1][j + c1] == 2) {
								for (int inc = c1 + 1; j + inc < 8; inc++) {
									if (disk[i - inc][j + inc] == 0) {
										probableArray[pc] = i - inc;
										probableArray[pc + 1] = j + inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i - inc][j + inc] == 2)
										continue;
									else if (disk[i - inc][j + inc] == 1)
										break;
								}
							}
						}
					}
				}
			}
		Outter: for (int i = 0; i < 6; i++) {
			Inner: for (int j = 2; j < 8; j++) {
				if (disk[i][j] == 1) {
					for (int c1 = 1; j - c1 >= 0; c1++) {
						if (disk[i + c1][j - c1] == 1)
							continue Outter;
						else if (disk[i + c1][j - c1] == 0)
							continue Outter;
						else if (disk[i + c1][j - c1] == 2) {
							for (int inc = c1 + 1; j - inc >= 0; inc++) {
								if (disk[i + inc][j - inc] == 0) {
									probableArray[pc] = i + inc;
									probableArray[pc + 1] = j - inc;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i + inc][j - inc] == 2)
									continue;
								else if (disk[i + inc][j - inc] == 1)
									break;
							}
						}
					}
				}
			}
		}
			Outter: for (int i = 0; i < 6; i++) {
				Inner: for (int j = 0; j < 6; j++) {
					if (disk[i][j] == 1) {
						for (int c1 = 1; j + c1 < 8; c1++) {
							if (disk[i + c1][j + c1] == 1)
								continue Outter;
							else if (disk[i + c1][j + c1] == 0)
								continue Outter;
							else if (disk[i + c1][j + c1] == 2) {
								for (int inc = c1 + 1; j + inc < 8; inc++) {
									if (disk[i + inc][j + inc] == 0) {
										probableArray[pc] = i + inc;
										probableArray[pc + 1] = j + inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i + inc][j + inc] == 2)
										continue;
									else if (disk[i + inc][j + inc] == 1)
										break;
								}
							}
						}
					}
				}
			}
		Outter: for (int i = 2; i < 8; i++) {
			Inner: for (int j = 2; j < 8; j++) {
				if (disk[i][j] == 1) {
					for (int c1 = 1; j + c1 >= 0; c1++) {
						if (disk[i - c1][j - c1] == 1)
							continue Outter;
						else if (disk[i - c1][j - c1] == 0)
							continue Outter;
						else if (disk[i - c1][j - c1] == 2) {
							for (int inc = c1 + 1; j - inc >= 0; inc++) {
								if (disk[i - inc][j - inc] == 0) {
									probableArray[pc] = i - inc;
									probableArray[pc + 1] = j - inc;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i - inc][j - inc] == 2)
									continue;
								else if (disk[i - inc][j - inc] == 1)
									break;
							}
						}
					}
				}
			}
		}
		} 
		else {
			Outter: for (int i = 0; i < 8; i++) {
				Inner: for (int j = 0; j < 6; j++) {
					if (disk[i][j] == 2) {
						for (int c1 = 1; j + c1 < 8; c1++) {
							if (disk[i][j + c1] == 2)
								continue Outter;
							else if (disk[i][j + c1] == 0)
								continue Outter;
							else if (disk[i][j + c1] == 1) {
								for (int inc = c1 + 1; j + inc < 8; inc++) {
									if (disk[i][j + inc] == 0) {
										probableArray[pc] = i;
										probableArray[pc + 1] = j + inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i][j + inc] == 1)
										continue;
									else if (disk[i][j + inc] == 2)
										break;
								}

							}

						}
					}
				}
			}
		Outter: for (int i = 0; i < 6; i++) {
			Inner: for (int j = 0; j < 8; j++) {
				if (disk[i][j] == 2) {
					for (int c1 = 1; i + c1 < 8; c1++) {
						if (disk[i + c1][j] == 2)
							continue Outter;
						else if (disk[i + c1][j] == 0)
							continue Outter;
						else if (disk[i + c1][j] == 1) {
							for (int inc = c1 + 1; i + inc < 8; inc++) {
								if (disk[i + inc][j] == 0) {
									probableArray[pc] = i + inc;
									probableArray[pc + 1] = j;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i + inc][j] == 1)
									continue;
								else if (disk[i + inc][j] == 2)
									break;
							}
						}
					}
				}
			}
		}
			Outter: for (int i = 0; i < 8; i++) {
				Inner: for (int j = 2; j < 8; j++) {
					if (disk[i][j] == 2) {
						for (int c1 = 1; j - c1 >= 0; c1++) {
							if (disk[i][j - c1] == 2)
								continue Outter;
							else if (disk[i][j - c1] == 0)
								continue Outter;
							else if (disk[i][j - c1] == 1) {
								for (int inc = c1 + 1; j - inc >= 0; inc++) {
									if (disk[i][j - inc] == 0) {
										probableArray[pc] = i;
										probableArray[pc + 1] = j - inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i][j - inc] == 1)
										continue;
									else if (disk[i][j - inc] == 2)
										break;
								}
							}
						}
					}
				}
			}
		Outter: for (int i = 2; i < 8; i++) {
			Inner: for (int j = 0; j < 8; j++) {
				if (disk[i][j] == 2) {
					for (int c1 = 1; i - c1 >= 0; c1++) {
						if (disk[i - c1][j] == 2)
							continue Outter;
						else if (disk[i - c1][j] == 0)
							continue Outter;
						else if (disk[i - c1][j] == 1) {
							for (int inc = c1 + 1; i - inc >= 0; inc++) {
								if (disk[i - inc][j] == 0) {
									probableArray[pc] = i - inc;
									probableArray[pc + 1] = j;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i - inc][j] == 1)
									continue;
								else if (disk[i - inc][j] == 2)
									break;
							}
						}
					}
				}
			}
		}
			Outter: for (int i = 2; i < 8; i++) {
				Inner: for (int j = 0; j < 6; j++) {
					if (disk[i][j] == 2) {
						for (int c1 = 1; j + c1 < 8; c1++) {
							if (disk[i - c1][j + c1] == 2)
								continue Outter;
							else if (disk[i - c1][j + c1] == 0)
								continue Outter;
							else if (disk[i - c1][j + c1] == 1) {
								for (int inc = c1 + 1; j + inc < 8; inc++) {
									if (disk[i - inc][j + inc] == 0) {
										probableArray[pc] = i - inc;
										probableArray[pc + 1] = j + inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i - inc][j + inc] == 1)
										continue;
									else if (disk[i - inc][j + inc] == 2)
										break;
								}
							}
						}
					}
				}
			}
		Outter: for (int i = 0; i < 6; i++) {
			Inner: for (int j = 2; j < 8; j++) {
				if (disk[i][j] == 2) {
					for (int c1 = 1; j - c1 >= 0; c1++) {
						if (disk[i + c1][j - c1] == 2)
							continue Outter;
						else if (disk[i + c1][j - c1] == 0)
							continue Outter;
						else if (disk[i + c1][j - c1] == 1) {
							for (int inc = c1 + 1; j - inc >= 0; inc++) {
								if (disk[i + inc][j - inc] == 0) {
									probableArray[pc] = i + inc;
									probableArray[pc + 1] = j - inc;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i + inc][j - inc] == 1)
									continue;
								else if (disk[i + inc][j - inc] == 2)
									break;
							}
						}
					}
				}
			}
		}
			Outter: for (int i = 0; i < 6; i++) {
				Inner: for (int j = 0; j < 6; j++) {
					if (disk[i][j] == 2) {
						for (int c1 = 1; j + c1 < 8; c1++) {
							if (disk[i + c1][j + c1] == 2)
								continue Outter;
							else if (disk[i + c1][j + c1] == 0)
								continue Outter;
							else if (disk[i + c1][j + c1] == 1) {
								for (int inc = c1 + 1; j + inc < 8; inc++) {
									if (disk[i + inc][j + inc] == 0) {
										probableArray[pc] = i + inc;
										probableArray[pc + 1] = j + inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i + inc][j + inc] == 1)
										continue;
									else if (disk[i + inc][j + inc] == 2)
										break;
								}
							}
						}
					}
				}
			}
		Outter: for (int i = 2; i < 8; i++) {
			Inner: for (int j = 2; j < 8; j++) {
				if (disk[i][j] == 2) {
					for (int c1 = 1; j + c1 >= 0; c1++) {
						if (disk[i - c1][j - c1] == 2)
							continue Outter;
						else if (disk[i - c1][j - c1] == 0)
							continue Outter;
						else if (disk[i - c1][j - c1] == 1) {
							for (int inc = c1 + 1; j - inc >= 0; inc++) {
								if (disk[i - inc][j - inc] == 0) {
									probableArray[pc] = i - inc;
									probableArray[pc + 1] = j - inc;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i - inc][j - inc] == 1)
									continue;
								else if (disk[i - inc][j - inc] == 2)
									break;
							}
						}
					}
				}
			}
		}
		}
		if (probableArray[0] == -1)
			new Player2Yellow();

		/*
		 * final JLabel[][] labels = new JLabel[8][8]; MouseListener ml = new
		 * MouseAdapter() { public void mousePressed(MouseEvent me) { Object src
		 * = me.getSource(); int x = -1; int y = -1; for (int i = 0; i <
		 * labels.length; i++) { for (int j = 0; j < labels[i].length; j++) { if
		 * (src == labels[i][j]) { x = i; y = j; break; } } if (x >= 0) { break;
		 * } } if (x > 0) { Color c=MainBoard.ML.label.getForeground();
		 * if(color==1) MainBoard.ML.label.setForeground(Color.black); else
		 * MainBoard.ML.label.setForeground(Color.white); new Play(x,y,color);
		 * new Player2(); } else { System.out.println("Wrong choice"); } } };
		 * for (int row = 0; row < 8; row++) { for (int col = 0; col < 8; col++)
		 * { labels[row][col] = new JLabel(row + "," + col);
		 * labels[row][col].addMouseListener(ml); } }
		 */

		p = probableArray[0];
		new Ml3(p);
		//if (Bcounter == 0) {
		//	new ButtonMaker();
			//Bcounter++;
		//}
		new ButtonMaker(probableArray, array[0], array[1], Player1.color);
		/*
		 * int z=0; while(probableArray[z]!=-1){
		 * MainBoard.disk1[probableArray[z]][probableArray[z+1]].setForeground(
		 * Color.green); z+=2; }
		 */

	}
}

class Player2Yellow implements Intdisk {
	static int color;
	int pc = 0, p;
	int Bcounter = 0;
	static int[] array = { 0, 0, 0, 0 };

	Player2Yellow() {
		Arrays.fill(probableArray, -1);
		if (Player2.color == 1) {
			Outter: for (int i = 0; i < 8; i++) {
				Inner: for (int j = 0; j < 6; j++) {
					if (disk[i][j] == 1) {
						for (int c1 = 1; j + c1 < 8; c1++) {
							if (disk[i][j + c1] == 1)
								continue Outter;
							else if (disk[i][j + c1] == 0)
								continue Outter;
							else if (disk[i][j + c1] == 2) {
								for (int inc = c1 + 1; j + inc < 8; inc++) {
									if (disk[i][j + inc] == 0) {
										probableArray[pc] = i;
										probableArray[pc + 1] = j + inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i][j + inc] == 2)
										continue;
									else if (disk[i][j + inc] == 1)
										break;
								}

							}

						}
					}
				}
			}
		Outter: for (int i = 0; i < 6; i++) {
			Inner: for (int j = 0; j < 8; j++) {
				if (disk[i][j] == 1) {
					for (int c1 = 1; i + c1 < 8; c1++) {
						if (disk[i + c1][j] == 1)
							continue Outter;
						else if (disk[i + c1][j] == 0)
							continue Outter;
						else if (disk[i + c1][j] == 2) {
							for (int inc = c1 + 1; i + inc < 8; inc++) {
								if (disk[i + inc][j] == 0) {
									probableArray[pc] = i + inc;
									probableArray[pc + 1] = j;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i + inc][j] == 2)
									continue;
								else if (disk[i + inc][j] == 1)
									break;
							}
						}
					}
				}
			}
		}
			Outter: for (int i = 0; i < 8; i++) {
				Inner: for (int j = 2; j < 8; j++) {
					if (disk[i][j] == 1) {
						for (int c1 = 1; j - c1 >= 0; c1++) {
							if (disk[i][j - c1] == 1)
								continue Outter;
							else if (disk[i][j - c1] == 0)
								continue Outter;
							else if (disk[i][j - c1] == 2) {
								for (int inc = c1 + 1; j - inc >= 0; inc++) {
									if (disk[i][j - inc] == 0) {
										probableArray[pc] = i;
										probableArray[pc + 1] = j - inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i][j - inc] == 2)
										continue;
									else if (disk[i][j - inc] == 1)
										break;
								}
							}
						}
					}
				}
			}
		Outter: for (int i = 2; i < 8; i++) {
			Inner: for (int j = 0; j < 8; j++) {
				if (disk[i][j] == 1) {
					for (int c1 = 1; i - c1 >= 0; c1++) {
						if (disk[i - c1][j] == 1)
							continue Outter;
						else if (disk[i - c1][j] == 0)
							continue Outter;
						else if (disk[i - c1][j] == 2) {
							for (int inc = c1 + 1; i - inc >= 0; inc++) {
								if (disk[i - inc][j] == 0) {
									probableArray[pc] = i - inc;
									probableArray[pc + 1] = j;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i - inc][j] == 2)
									continue;
								else if (disk[i - inc][j] == 1)
									break;
							}
						}
					}
				}
			}
		}
			Outter: for (int i = 2; i < 8; i++) {
				Inner: for (int j = 0; j < 6; j++) {
					if (disk[i][j] == 1) {
						for (int c1 = 1; j + c1 < 8; c1++) {
							if (disk[i - c1][j + c1] == 1)
								continue Outter;
							else if (disk[i - c1][j + c1] == 0)
								continue Outter;
							else if (disk[i - c1][j + c1] == 2) {
								for (int inc = c1 + 1; j + inc < 8; inc++) {
									if (disk[i - inc][j + inc] == 0) {
										probableArray[pc] = i - inc;
										probableArray[pc + 1] = j + inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i - inc][j + inc] == 2)
										continue;
									else if (disk[i - inc][j + inc] == 1)
										break;
								}
							}
						}
					}
				}
			}
		Outter: for (int i = 0; i < 6; i++) {
			Inner: for (int j = 2; j < 8; j++) {
				if (disk[i][j] == 1) {
					for (int c1 = 1; j - c1 >= 0; c1++) {
						if (disk[i + c1][j - c1] == 1)
							continue Outter;
						else if (disk[i + c1][j - c1] == 0)
							continue Outter;
						else if (disk[i + c1][j - c1] == 2) {
							for (int inc = c1 + 1; j - inc >= 0; inc++) {
								if (disk[i + inc][j - inc] == 0) {
									probableArray[pc] = i + inc;
									probableArray[pc + 1] = j - inc;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i + inc][j - inc] == 2)
									continue;
								else if (disk[i + inc][j - inc] == 1)
									break;
							}
						}
					}
				}
			}
		}
			Outter: for (int i = 0; i < 6; i++) {
				Inner: for (int j = 0; j < 6; j++) {
					if (disk[i][j] == 1) {
						for (int c1 = 1; j + c1 < 8; c1++) {
							if (disk[i + c1][j + c1] == 1)
								continue Outter;
							else if (disk[i + c1][j + c1] == 0)
								continue Outter;
							else if (disk[i + c1][j + c1] == 2) {
								for (int inc = c1 + 1; j + inc < 8; inc++) {
									if (disk[i + inc][j + inc] == 0) {
										probableArray[pc] = i + inc;
										probableArray[pc + 1] = j + inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i + inc][j + inc] == 2)
										continue;
									else if (disk[i + inc][j + inc] == 1)
										break;
								}
							}
						}
					}
				}
			}
		Outter: for (int i = 2; i < 8; i++) {
			Inner: for (int j = 2; j < 8; j++) {
				if (disk[i][j] == 1) {
					for (int c1 = 1; j + c1 >= 0; c1++) {
						if (disk[i - c1][j - c1] == 1)
							continue Outter;
						else if (disk[i - c1][j - c1] == 0)
							continue Outter;
						else if (disk[i - c1][j - c1] == 2) {
							for (int inc = c1 + 1; j - inc >= 0; inc++) {
								if (disk[i - inc][j - inc] == 0) {
									probableArray[pc] = i - inc;
									probableArray[pc + 1] = j - inc;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i - inc][j - inc] == 2)
									continue;
								else if (disk[i - inc][j - inc] == 1)
									break;
							}
						}
					}
				}
			}
		}
		} 
		else {
			Outter: for (int i = 0; i < 8; i++) {
				Inner: for (int j = 0; j < 6; j++) {
					if (disk[i][j] == 2) {
						for (int c1 = 1; j + c1 < 8; c1++) {
							if (disk[i][j + c1] == 2)
								continue Outter;
							else if (disk[i][j + c1] == 0)
								continue Outter;
							else if (disk[i][j + c1] == 1) {
								for (int inc = c1 + 1; j + inc < 8; inc++) {
									if (disk[i][j + inc] == 0) {
										probableArray[pc] = i;
										probableArray[pc + 1] = j + inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i][j + inc] == 1)
										continue;
									else if (disk[i][j + inc] == 2)
										break;
								}

							}

						}
					}
				}
			}
		Outter: for (int i = 0; i < 6; i++) {
			Inner: for (int j = 0; j < 8; j++) {
				if (disk[i][j] == 2) {
					for (int c1 = 1; i + c1 < 8; c1++) {
						if (disk[i + c1][j] == 2)
							continue Outter;
						else if (disk[i + c1][j] == 0)
							continue Outter;
						else if (disk[i + c1][j] == 1) {
							for (int inc = c1 + 1; i + inc < 8; inc++) {
								if (disk[i + inc][j] == 0) {
									probableArray[pc] = i + inc;
									probableArray[pc + 1] = j;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i + inc][j] == 1)
									continue;
								else if (disk[i + inc][j] == 2)
									break;
							}
						}
					}
				}
			}
		}
			Outter: for (int i = 0; i < 8; i++) {
				Inner: for (int j = 2; j < 8; j++) {
					if (disk[i][j] == 2) {
						for (int c1 = 1; j - c1 >= 0; c1++) {
							if (disk[i][j - c1] == 2)
								continue Outter;
							else if (disk[i][j - c1] == 0)
								continue Outter;
							else if (disk[i][j - c1] == 1) {
								for (int inc = c1 + 1; j - inc >= 0; inc++) {
									if (disk[i][j - inc] == 0) {
										probableArray[pc] = i;
										probableArray[pc + 1] = j - inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i][j - inc] == 1)
										continue;
									else if (disk[i][j - inc] == 2)
										break;
								}
							}
						}
					}
				}
			}
		Outter: for (int i = 2; i < 8; i++) {
			Inner: for (int j = 0; j < 8; j++) {
				if (disk[i][j] == 2) {
					for (int c1 = 1; i - c1 >= 0; c1++) {
						if (disk[i - c1][j] == 2)
							continue Outter;
						else if (disk[i - c1][j] == 0)
							continue Outter;
						else if (disk[i - c1][j] == 1) {
							for (int inc = c1 + 1; i - inc >= 0; inc++) {
								if (disk[i - inc][j] == 0) {
									probableArray[pc] = i - inc;
									probableArray[pc + 1] = j;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i - inc][j] == 1)
									continue;
								else if (disk[i - inc][j] == 2)
									break;
							}
						}
					}
				}
			}
		}
			Outter: for (int i = 2; i < 8; i++) {
				Inner: for (int j = 0; j < 6; j++) {
					if (disk[i][j] == 2) {
						for (int c1 = 1; j + c1 < 8; c1++) {
							if (disk[i - c1][j + c1] == 2)
								continue Outter;
							else if (disk[i - c1][j + c1] == 0)
								continue Outter;
							else if (disk[i - c1][j + c1] == 1) {
								for (int inc = c1 + 1; j + inc < 8; inc++) {
									if (disk[i - inc][j + inc] == 0) {
										probableArray[pc] = i - inc;
										probableArray[pc + 1] = j + inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i - inc][j + inc] == 1)
										continue;
									else if (disk[i - inc][j + inc] == 2)
										break;
								}
							}
						}
					}
				}
			}
		Outter: for (int i = 0; i < 6; i++) {
			Inner: for (int j = 2; j < 8; j++) {
				if (disk[i][j] == 2) {
					for (int c1 = 1; j - c1 >= 0; c1++) {
						if (disk[i + c1][j - c1] == 2)
							continue Outter;
						else if (disk[i + c1][j - c1] == 0)
							continue Outter;
						else if (disk[i + c1][j - c1] == 1) {
							for (int inc = c1 + 1; j - inc >= 0; inc++) {
								if (disk[i + inc][j - inc] == 0) {
									probableArray[pc] = i + inc;
									probableArray[pc + 1] = j - inc;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i + inc][j - inc] == 1)
									continue;
								else if (disk[i + inc][j - inc] == 2)
									break;
							}
						}
					}
				}
			}
		}
			Outter: for (int i = 0; i < 6; i++) {
				Inner: for (int j = 0; j < 6; j++) {
					if (disk[i][j] == 2) {
						for (int c1 = 1; j + c1 < 8; c1++) {
							if (disk[i + c1][j + c1] == 2)
								continue Outter;
							else if (disk[i + c1][j + c1] == 0)
								continue Outter;
							else if (disk[i + c1][j + c1] == 1) {
								for (int inc = c1 + 1; j + inc < 8; inc++) {
									if (disk[i + inc][j + inc] == 0) {
										probableArray[pc] = i + inc;
										probableArray[pc + 1] = j + inc;
										// System.out.println(probableArray[pc]);
										// System.out.println(probableArray[pc+1]);
										pc += 2;
										break;
									} else if (disk[i + inc][j + inc] == 1)
										continue;
									else if (disk[i + inc][j + inc] == 2)
										break;
								}
							}
						}
					}
				}
			}
		Outter: for (int i = 2; i < 8; i++) {
			Inner: for (int j = 2; j < 8; j++) {
				if (disk[i][j] == 2) {
					for (int c1 = 1; j + c1 >= 0; c1++) {
						if (disk[i - c1][j - c1] == 2)
							continue Outter;
						else if (disk[i - c1][j - c1] == 0)
							continue Outter;
						else if (disk[i - c1][j - c1] == 1) {
							for (int inc = c1 + 1; j - inc >= 0; inc++) {
								if (disk[i - inc][j - inc] == 0) {
									probableArray[pc] = i - inc;
									probableArray[pc + 1] = j - inc;
									// System.out.println(probableArray[pc]);
									// System.out.println(probableArray[pc+1]);
									pc += 2;
									break;
								} else if (disk[i - inc][j - inc] == 1)
									continue;
								else if (disk[i - inc][j - inc] == 2)
									break;
							}
						}
					}
				}
			}
		}
		}
		if (probableArray[0] == -1)
			new Player1Yellow();

		p = probableArray[0];
		new Ml4(p);
		//if (Bcounter == 0) {
			//new ButtonMaker();
			//Bcounter++;
		//}
		new ButtonMaker(probableArray, array[0], array[1], Player2.color);
	}
}

class Ml3 extends MouseAdapter {
	int p;
	MouseListener ml = new MouseAdapter() {
		public void mousePressed(MouseEvent me) {
			Object src = me.getSource();
			int x = -1;
			int y = -1;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (src == ChangedMainBoard.disk1[i][j]) {
						x = i;
						y = j;
						break;
					}
				}
				if (x >= 0) {
					break;
				}
			}
			if (p == -1) {
				JOptionPane.showMessageDialog(null, "Wrong Choice");
			}
			if (x >= 0) {
				for (int i = 0; i < 4; i++) {
					if (Player1Yellow.array[i] == 0) {
						Player1Yellow.array[i] = x;
						Player1Yellow.array[i + 1] = y;
						break;
					}
				}
				new PlayYellow(x, y, Player1.color);
				new Player2Yellow();
			}
		}
	};

	Ml3(int probable) {
		p = probable;
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				ChangedMainBoard.disk1[row][col].addMouseListener(ml);
			}
		}
		new ShowTurn(1);
		new ShowTurn('c');
	}
}

class Ml4 extends MouseAdapter {
	int p;
	MouseListener ml = new MouseAdapter() {
		public void mousePressed(MouseEvent me) {
			Object src = me.getSource();
			int x = -1;
			int y = -1;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (src == ChangedMainBoard.disk1[i][j]) {
						x = i;
						y = j;
						break;
					}
				}
				if (x >= 0) {
					break;
				}
			}
			if (p == -1) {
				JOptionPane.showMessageDialog(null, "Wrong Choice");
			}
			if (x >= 0) {
				for (int i = 0; i < 4; i++) {
					if (Player2Yellow.array[i] == 0) {
						Player2Yellow.array[i] = x;
						Player2Yellow.array[i + 1] = y;
						break;
					}
				}
				new PlayYellow(x, y, Player2.color);
				new Player1Yellow();
			}
		}
	};

	Ml4(int probable) {
		p = probable;
		for (int row = 0; row < 8; row++) {
			for (int col = 0; col < 8; col++) {
				ChangedMainBoard.disk1[row][col].addMouseListener(ml);
			}
		}
		new ShowTurn('c');
		new ShowTurn(1);
	}
}

class PlayYellow implements Intdisk {
	boolean flag = false;
	int counter = 0;
	static int level = 1;

	PlayYellow(int x, int y, int color) {
		// for(int z:probableArray){
		// if(x==z&&y==z+1){
		flag = true;
		if (color == 1) {
			// System.arraycopy(disk,0,Undo.disk3,0,Undo.disk3.length);
			if (y != 6 && y != 7) {
				for (int c1 = 1; y + c1 < 8; c1++) {
					if (disk[x][y + c1] == 1)
						break;
					else if (disk[x][y + c1] == 0)
						break;
					else if (disk[x][y + c1] == 2) {
						for (int inc = c1 + 1; y + inc < 8; inc++) {
							if (disk[x][y + inc] == 1) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x][y+(c1+i)]=disk[x][y+(c1+i)];
									disk[x][y + (c1 + i)] = 1;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 1;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x][y + inc] == 2) {
								counter++;
								continue;
							} else if (disk[x][y + inc] == 0)
								break;
						}
					}
				}
			}
			if (x != 6 && x != 7) {
				for (int c1 = 1; x + c1 < 8; c1++) {
					if (disk[x + c1][y] == 1)
						break;
					else if (disk[x + c1][y] == 0)
						break;
					else if (disk[x + c1][y] == 2) {
						for (int inc = c1 + 1; x + inc < 8; inc++) {
							if (disk[x + inc][y] == 1) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x+(c1+i)][y]=disk[x+(c1+i)][y];
									disk[x + (c1 + i)][y] = 1;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 1;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x + inc][y] == 2) {
								counter++;
								continue;
							} else if (disk[x + inc][y] == 0)
								break;
						}
					}
				}
			}
			if (y != 0 && y != 1) {
				for (int c1 = 1; y - c1 >= 0; c1++) {
					if (disk[x][y - c1] == 1)
						break;
					else if (disk[x][y - c1] == 0)
						break;
					else if (disk[x][y - c1] == 2) {
						for (int inc = c1 + 1; y - inc >= 0; inc++) {
							if (disk[x][y - inc] == 1) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x][y-(c1-i)]=disk[x][y-(c1-i)];
									disk[x][y - (c1 - i)] = 1;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 1;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x][y - inc] == 2) {
								counter++;
								continue;
							} else if (disk[x][y - inc] == 0)
								break;
						}
					}
				}
			}
			if (x != 0 && x != 1) {
				for (int c1 = 1; x - c1 >= 0; c1++) {
					if (disk[x - c1][y] == 1)
						break;
					else if (disk[x - c1][y] == 0)
						break;
					else if (disk[x - c1][y] == 2) {
						for (int inc = c1 + 1; x - inc >= 0; inc++) {
							if (disk[x - inc][y] == 1) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x-(c1-i)][y]=disk[x-(c1-i)][y];
									disk[x - (c1 - i)][y] = 1;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 1;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x - inc][y] == 2) {
								counter++;
								continue;
							} else if (disk[x - inc][y] == 0)
								break;
						}
					}
				}
			}
			if (y != 6 && y != 7 && x != 1) {
				for (int c1 = 1; y + c1 < 8; c1++) {
					if (disk[x - c1][y + c1] == 1)
						break;
					else if (disk[x - c1][y + c1] == 0)
						break;
					else if (disk[x - c1][y + c1] == 2) {
						for (int inc = c1 + 1; y + inc < 8; inc++) {
							if (disk[x - inc][y + inc] == 1) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x-(c1-i)][y+(c1+i)]=disk[x-(c1-i)][y+(c1+i)];
									disk[x - (c1 - i)][y + (c1 + i)] = 1;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 1;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x - inc][y + inc] == 2) {
								counter++;
								continue;
							} else if (disk[x - inc][y + inc] == 0)
								break;
						}
					}
				}
			}
			if (y != 0 && y != 1 && x != 6) {
				for (int c1 = 1; y - c1 >= 0; c1++) {
					if (disk[x + c1][y - c1] == 1)
						break;
					else if (disk[x + c1][y - c1] == 0)
						break;
					else if (disk[x + c1][y - c1] == 2) {
						for (int inc = c1 + 1; y - inc >= 0; inc++) {
							if (disk[x + inc][y - inc] == 1) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x+(c1+i)][y-(c1-i)]=disk[x+(c1+i)][y-(c1-i)];
									disk[x + (c1 + i)][y - (c1 - i)] = 1;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 1;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x + inc][y - inc] == 2) {
								counter++;
								continue;
							} else if (disk[x + inc][y - inc] == 0)
								break;
						}
					}
				}
			}
			if (y != 6 && y != 7 && x != 6) {
				for (int c1 = 1; y + c1 < 8; c1++) {
					if (disk[x + c1][y + c1] == 1)
						break;
					else if (disk[x + c1][y + c1] == 0)
						break;
					else if (disk[x + c1][y + c1] == 2) {
						for (int inc = c1 + 1; y + inc < 8; inc++) {
							if (disk[x + inc][y + inc] == 1) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x+(c1+i)][y+(c1+i)]=disk[x+(c1+i)][y+(c1+i)];
									disk[x + (c1 + i)][y + (c1 + i)] = 1;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 1;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x + inc][y + inc] == 2) {
								counter++;
								continue;
							} else if (disk[x + inc][y + inc] == 0)
								break;
						}
					}
				}
			}
			if (y != 0 && y != 1 && x != 1) {
				for (int c1 = 1; y + c1 >= 0; c1++) {
					if (disk[x - c1][y - c1] == 1)
						break;
					else if (disk[x - c1][y - c1] == 0)
						break;
					else if (disk[x - c1][y - c1] == 2) {
						for (int inc = c1 + 1; y - inc >= 0; inc++) {
							if (disk[x - inc][y - inc] == 1) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x-(c1-i)][y-(c1-i)]=disk[x-(c1-i)][y-(c1-i)];
									disk[x - (c1 - i)][y - (c1 - i)] = 1;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 1;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x - inc][y - inc] == 2) {
								counter++;
								continue;
							} else if (disk[x - inc][y - inc] == 0)
								break;
						}
					}
				}
			}
		}
		// if the color is white
		else {
			// System.arraycopy(disk,0,Undo.disk3,0,Undo.disk3.length);
			if (y != 6 && y != 7) {
				for (int c1 = 1; y + c1 < 8; c1++) {
					if (disk[x][y + c1] == 2)
						break;
					else if (disk[x][y + c1] == 0)
						break;
					else if (disk[x][y + c1] == 1) {
						for (int inc = c1 + 1; y + inc < 8; inc++) {
							if (disk[x][y + inc] == 2) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x][y+(c1+i)]=disk[x][y+(c1+i)];
									disk[x][y + (c1 + i)] = 2;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 2;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x][y + inc] == 1) {
								counter++;
								continue;
							} else if (disk[x][y + inc] == 0)
								break;
						}
					}
				}
			}
			if (x != 6 && x != 7) {
				for (int c1 = 1; x + c1 < 8; c1++) {
					if (disk[x + c1][y] == 2)
						break;
					else if (disk[x + c1][y] == 0)
						break;
					else if (disk[x + c1][y] == 1) {
						for (int inc = c1 + 1; x + inc < 8; inc++) {
							if (disk[x + inc][y] == 2) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x+(c1+i)][y]=disk[x+(c1+i)][y];
									disk[x + (c1 + i)][y] = 2;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 2;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x + inc][y] == 1) {
								counter++;
								continue;
							} else if (disk[x + inc][y] == 0)
								break;
						}
					}
				}
			}
			if (y != 0 && y != 1) {
				for (int c1 = 1; y - c1 >= 0; c1++) {
					if (disk[x][y - c1] == 2)
						break;
					else if (disk[x][y - c1] == 0)
						break;
					else if (disk[x][y - c1] == 1) {
						for (int inc = c1 + 1; y - inc >= 0; inc++) {
							if (disk[x][y - inc] == 2) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x][y-(c1-i)]=disk[x][y-(c1-i)];
									disk[x][y - (c1 - i)] = 2;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 2;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x][y - inc] == 1) {
								counter++;
								continue;
							} else if (disk[x][y - inc] == 0)
								break;
						}
					}
				}
			}
			if (x != 0 && x != 1) {
				for (int c1 = 1; x - c1 >= 0; c1++) {
					if (disk[x - c1][y] == 2)
						break;
					else if (disk[x - c1][y] == 0)
						break;
					else if (disk[x - c1][y] == 1) {
						for (int inc = c1 + 1; x - inc >= 0; inc++) {
							if (disk[x - inc][y] == 2) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x-(c1-i)][y]=disk[x-(c1-i)][y];
									disk[x - (c1 - i)][y] = 2;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 2;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x - inc][y] == 1) {
								counter++;
								continue;
							} else if (disk[x - inc][y] == 0)
								break;
						}
					}
				}
			}
			if (y != 6 && y != 7 && x != 1) {
				for (int c1 = 1; y + c1 < 8; c1++) {
					if (disk[x - c1][y + c1] == 2)
						break;
					else if (disk[x - c1][y + c1] == 0)
						break;
					else if (disk[x - c1][y + c1] == 1) {
						for (int inc = c1 + 1; y + inc < 8; inc++) {
							if (disk[x - inc][y + inc] == 2) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x-(c1-i)][y+(c1+i)]=disk[x-(c1-i)][y+(c1+i)];
									disk[x - (c1 - i)][y + (c1 + i)] = 2;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 2;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x - inc][y + inc] == 1) {
								counter++;
								continue;
							} else if (disk[x - inc][y + inc] == 0)
								break;
						}
					}
				}
			}
			if (y != 0 && y != 1 && x != 6) {
				for (int c1 = 1; y - c1 >= 0; c1++) {
					if (disk[x + c1][y - c1] == 2)
						break;
					else if (disk[x + c1][y - c1] == 0)
						break;
					else if (disk[x + c1][y - c1] == 1) {
						for (int inc = c1 + 1; y - inc >= 0; inc++) {
							if (disk[x + inc][y - inc] == 2) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x+(c1+i)][y-(c1-i)]=disk[x+(c1+i)][y-(c1-i)];
									disk[x + (c1 + i)][y - (c1 - i)] = 2;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 2;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x + inc][y - inc] == 1) {
								counter++;
								continue;
							} else if (disk[x + inc][y - inc] == 0)
								break;
						}
					}
				}
			}
			if (y != 6 && y != 7 && x != 6) {
				for (int c1 = 1; y + c1 < 8; c1++) {
					if (disk[x + c1][y + c1] == 2)
						break;
					else if (disk[x + c1][y + c1] == 0)
						break;
					else if (disk[x + c1][y + c1] == 1) {
						for (int inc = c1 + 1; y + inc < 8; inc++) {
							if (disk[x + inc][y + inc] == 2) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x+(c1+i)][y+(c1+i)]=disk[x+(c1+i)][y+(c1+i)];
									disk[x + (c1 + i)][y + (c1 + i)] = 2;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 2;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x + inc][y + inc] == 1) {
								counter++;
								continue;
							} else if (disk[x + inc][y + inc] == 0)
								break;
						}
					}
				}
			}
			if (y != 0 && y != 1 && x != 1) {
				for (int c1 = 1; y + c1 >= 0; c1++) {
					if (disk[x - c1][y - c1] == 2)
						break;
					else if (disk[x - c1][y - c1] == 0)
						break;
					else if (disk[x - c1][y - c1] == 1) {
						for (int inc = c1 + 1; y - inc >= 0; inc++) {
							if (disk[x - inc][y - inc] == 2) {
								for (int i = 0; i <= counter; i++) {
									// Undo.disk3[x-(c1-i)][y-(c1-i)]=disk[x-(c1-i)][y-(c1-i)];
									disk[x - (c1 - i)][y - (c1 - i)] = 2;
								}
								// Undo.disk3[x][y]=-1;
								disk[x][y] = 2;
								// System.out.println(probableArray[pc]);
								// System.out.println(probableArray[pc+1]);
								counter = 0;
								break;
							} else if (disk[x - inc][y - inc] == 1) {
								counter++;
								continue;
							} else if (disk[x - inc][y - inc] == 0)
								break;
						}
					}
				}
			}
		}
		// }
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (disk[i][j] == 1)
					ChangedMainBoard.disk1[i][j].setForeground(Color.red);
				else if (disk[i][j] == 2)
					ChangedMainBoard.disk1[i][j].setForeground(Color.green);
			}
		}

		new Counter(level);
		// if(flag==false)
		// JOptionPane.showMessageDialog(null,"Wrong Choice,Select a appropriate
		// one");
		// break;
		// }
	}
}

class MainBoard extends JFrame {
	JPanel jp = new JPanel(new GridLayout(8, 8, 4, 4));
	static JLabel[][] disk1 = new JLabel[8][8];
	JMenuBar jmb = new JMenuBar();
	JMenu fileMenu = new JMenu("File");
	JMenuItem newItem = new JMenuItem("New");
	JMenuItem saveItem = new JMenuItem("Save");
	JMenuItem saveAsItem = new JMenuItem("Save as..");
	JMenuItem openItem = new JMenuItem("Open");
	JMenuItem exitItem = new JMenuItem("Exit");
	JMenu editMenu = new JMenu("Edit");
	JMenuItem changeColorItem = new JMenuItem("Change the colors");
	JMenuItem changeFontItem = new JMenuItem("Change the fonts");
	JMenuItem yellow = new JMenuItem(" Change color:Yellow");
	static LiveScore ls = new LiveScore();

	MainBoard() {
		super("Reversi game");
		setSize(500, 500);
		setLocation(550, 50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(jp);
		jp.setBackground(Color.gray);
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++) {
				disk1[i][j] = new JLabel("\u2022", SwingConstants.CENTER);
				jp.add(disk1[i][j]);
				disk1[i][j].setForeground(Color.lightGray);
				disk1[i][j].setOpaque(true);
				disk1[i][j].setBackground(Color.lightGray);
				disk1[i][j].setFont(new Font("Arial", Font.PLAIN, 90));
				disk1[i][j].addMouseListener(new ML(i, j));
			}
		disk1[3][3].setForeground(Color.white);
		disk1[4][4].setForeground(Color.white);
		disk1[3][4].setForeground(Color.black);
		disk1[4][3].setForeground(Color.black);
		setJMenuBar(jmb);
		jmb.add(fileMenu);
		jmb.add(editMenu);
		fileMenu.add(newItem);
		fileMenu.add(saveItem);
		fileMenu.add(saveAsItem);
		fileMenu.add(openItem);
		fileMenu.add(exitItem);
		editMenu.add(changeColorItem);
		editMenu.add(changeFontItem);
		changeColorItem.add(yellow);
		newItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				brandnew();
			}
		});
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		saveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		saveAsItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveAs();
			}
		});
		/*openItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});*/
		changeColorItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changecolor();
			}
		});
		setVisible(true);

	}

	static class ML implements MouseListener {
		static JLabel label;
		int x, y;

		ML(int x, int y) {
			label = disk1[x][y];
			this.x = x;
			this.y = y;
		}

		public void mouseClicked(MouseEvent e) {
			// YOU SHOULD RE-WRITE THIS METHOD CORRECTLY
			// I WRONGLY CODED THIS METHOD JUST FOR FUN!
			// Color c=label.getForeground();
			// label.setForeground(Color.red);
			// new Play(x,y,Player2.color);
			// new Player1();
			// JOptionPane.showMessageDialog(null, "Dear student,\n\nYou need to
			// complete the code by yourself.\nThink deeply and write your
			// program carefully.\n\nGood luck!");
			// label.setForeground(c);

		}

		public void mouseEntered(MouseEvent e) {
		}

		public void mouseExited(MouseEvent e) {
		}

		public void mousePressed(MouseEvent e) {
		}

		public void mouseReleased(MouseEvent e) {
		}
	}

	public void exit() {
		System.exit(0);
	}

	public void brandnew() {
		String[] str = { null, null };
		ls.dispose();
		dispose();
		Othello.main(str);
		new LiveScore();
		new ButtonMaker();
		new HintBoard();
	}
	public void save(){
		new Save();
	}
	public void saveAs(){
		new SaveAs();
	}
	/*public void open(){
		new Open();
	}*/
	public void changecolor(){
		ls.dispose();
		dispose();
		new ChangedMainBoard();
		new LiveScore();
		new ButtonMaker();
		new HintBoard();
		new Intializer();
		new Player1Yellow();
		new Player2Yellow();
		Thread thread = new Thread(new TimerTotal());
		thread.start();
	}
}

class ChangedMainBoard extends JFrame{
	JPanel jp = new JPanel(new GridLayout(8, 8, 4, 4));
	static JLabel[][] disk1 = new JLabel[8][8];
	JMenuBar jmb = new JMenuBar();
	JMenu fileMenu = new JMenu("File");
	JMenuItem newItem = new JMenuItem("New");
	JMenuItem saveItem = new JMenuItem("Save");
	JMenuItem saveAsItem = new JMenuItem("Save as..");
	JMenuItem openItem = new JMenuItem("Open");
	JMenuItem exitItem = new JMenuItem("Exit");
	JMenu editMenu = new JMenu("Edit");
	JMenuItem changeColorItem = new JMenuItem("Change the colors:");
	JMenuItem changeFontItem = new JMenuItem("Change the fonts");
	JMenuItem def = new JMenuItem(" Change color:Default");
	static LiveScore ls = new LiveScore();

	ChangedMainBoard() {
		super("Reversi game");
		setSize(500, 500);
		setLocation(550, 50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(jp);
		jp.setBackground(Color.gray);
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++) {
				disk1[i][j] = new JLabel("\u2022", SwingConstants.CENTER);
				jp.add(disk1[i][j]);
				disk1[i][j].setForeground(Color.yellow);
				disk1[i][j].setOpaque(true);
				disk1[i][j].setBackground(Color.yellow);
				disk1[i][j].setFont(new Font("Arial", Font.PLAIN, 90));
			}
		disk1[3][3].setForeground(Color.green);
		disk1[4][4].setForeground(Color.green);
		disk1[3][4].setForeground(Color.red);
		disk1[4][3].setForeground(Color.red);
		setJMenuBar(jmb);
		jmb.add(fileMenu);
		jmb.add(editMenu);
		fileMenu.add(newItem);
		fileMenu.add(saveItem);
		fileMenu.add(saveAsItem);
		fileMenu.add(openItem);
		fileMenu.add(exitItem);
		editMenu.add(changeColorItem);
		editMenu.add(changeFontItem);
		editMenu.add(def);
		newItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				brandnew();
			}
		});
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exit();
			}
		});
		saveItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				save();
			}
		});
		saveAsItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveAs();
			}
		});
		/*openItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				open();
			}
		});*/
		changeColorItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changecolor();
			}
		});
		def.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				defaultcolor();
			}
		});
		setVisible(true);

	}
	
	public void exit() {
		System.exit(0);
	}

	public void brandnew() {
		String[] str = { null, null };
		ls.dispose();
		dispose();
		Othello.main(str);
		new LiveScore();
		new ButtonMaker();
		new HintBoard();
	}
	public void save(){
		new Save();
	}
	public void saveAs(){
		new SaveAs();
	}
	/*public void open(){
		new Open();
	}*/
	public void changecolor(){
		ls.dispose();
		dispose();
		new ChangedMainBoard();
		new LiveScore();
		new ButtonMaker();
		new HintBoard();
	}
	public void defaultcolor(){
		String[] str = { null, null };
		ls.dispose();
		dispose();
		Othello.main(str);
		new LiveScore();
		new ButtonMaker();
		new HintBoard();
		
	}
}

class LiveScore extends JFrame {
	JPanel jp = new JPanel(new GridLayout(64, 3, 1, 1));
	static JLabel[][] score = new JLabel[62][3];

	LiveScore() {
		super("Live scores");
		setSize(200, 850);
		setLocation(1182, 50);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().add(jp);
		jp.setBackground(Color.gray);
		score[0][0] = new JLabel("LEVEL", SwingConstants.CENTER);
		score[0][1] = new JLabel("WHITE", SwingConstants.CENTER);
		score[0][2] = new JLabel("BLACK", SwingConstants.CENTER);
		score[1][0] = new JLabel("0", SwingConstants.CENTER);
		score[1][1] = new JLabel("2", SwingConstants.CENTER);
		score[1][2] = new JLabel("2", SwingConstants.CENTER);
		for (int i = 2; i < 62; i++) {
			score[i][0] = new JLabel("" + (i - 1), SwingConstants.CENTER);
			score[i][1] = new JLabel("", SwingConstants.CENTER);
			score[i][2] = new JLabel("", SwingConstants.CENTER);
		}
		for (int i = 0; i < 62; i++)
			for (int j = 0; j < 3; j++) {
				score[i][j].setOpaque(true);
				score[i][j].setBackground(Color.lightGray);
				jp.add(score[i][j]);
			}
		setVisible(true);
	}

	/*
	 * static void setScore(int level, boolean white, int value) { score[level +
	 * 1][white ? 1 : 2].setText(value + ""); }
	 */
	static void setScore(int level, int Bcounter, int Wcounter) {
		score[level + 1][1].setText(Bcounter + "");
		score[level + 1][2].setText(Wcounter + "");
	}
}

class Counter implements Intdisk {
	int Bcounter = 0, Wcounter = 0;
	int count = 0;

	Counter(int level) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (disk[i][j] == 1) {
					Bcounter++;
				}
			}
		}
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				if (disk[i][j] == 2) {
					Wcounter++;
					count++;
				}
			}
		}
		LiveScore.setScore(Play.level, Wcounter, Bcounter);
		if (count == 2) {
			Play.level++;
			count = 0;
		}

	}
}

class ButtonMaker extends JFrame {
	int x, y, color;
	static int counter = 0;
	JPanel jp = new JPanel();
	Button b = new Button("Hint");
	Button b1 = new Button("Undo");

	ButtonMaker() {
		if (counter == 0) {
			hintBoard();
			counter++;
		}
	}

	ButtonMaker(int[] pa, int x, int y, int color) {
		super("");
		jp.add(b);
		jp.add(b1);
		setSize(500, 100);
		setLocation(50, 550);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().add(jp);
		jp.setBackground(Color.red);
		this.x = x;
		this.y = y;
		this.color = color;
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int z = 0;
				while (pa[z] != -1) {
					HintBoard.disk2[pa[z]][pa[z + 1]].setForeground(Color.red);
					z += 2;
				}
			}
		});
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				HintBoard.disk2[i][j].setForeground(Color.black);
			}
		}
		/*
		 * b1.addActionListener(new ActionListener(){ public void
		 * actionPerformed(ActionEvent e){ undo(); } });
		 */
		setVisible(true);
	}

	/*
	 * public void undo(){ new Undo(x,y,color); }
	 */
	public void hintBoard() {
		new HintBoard();
	}

}

class HintBoard extends JFrame {
	JPanel jp = new JPanel(new GridLayout(8, 8, 4, 4));
	static JLabel[][] disk2 = new JLabel[8][8];

	HintBoard() {
		super("HintBoard");
		setSize(500, 500);
		setLocation(50, 50);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().add(jp);
		jp.setBackground(Color.gray);
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++) {
				disk2[i][j] = new JLabel("\u2022", SwingConstants.CENTER);
				jp.add(disk2[i][j]);
				disk2[i][j].setForeground(Color.black);
				disk2[i][j].setOpaque(true);
				disk2[i][j].setBackground(Color.black);
				disk2[i][j].setFont(new Font("Arial", Font.PLAIN, 90));
			}
		setVisible(true);
		// dispose();

	}
}

/*
 * class Undo{ static int [][] disk3=new int[8][8]; Undo( int x, int y,int
 * color){ if(color==1) disk3[x][y]=1; else if(color==2) disk3[x][y]=2;
 * 
 * Player1.array[0]=Player1.array[2]; Player1.array[1]=Player1.array[3];
 * Player1.array[2]=Player1.array[3]=0; Player2.array[0]=Player2.array[2];
 * Player2.array[1]=Player2.array[3]; Player2.array[2]=Player2.array[3]=0;
 * for(int i=0;i<8;i++){ for(int j=0;j<8;j++){ if(disk3[i][j]==1){
 * MainBoard.disk1[i][j].setForeground(Color.black); //
 * MainBoard.disk1[3][3].setForeground(Color.black); } else if(disk3[i][j]==2)
 * MainBoard.disk1[i][j].setForeground(Color.white); //else if (disk3[i][j]==-1)
 * //MainBoard.disk1[i][j].setForeground(Color.lightGray); } } } }
 */
class ShowTurn extends JFrame{
    static int counter=2;
	JPanel jp = new JPanel(new GridLayout(2, 2, 4, 4));
	static JLabel[][] disk4 = new JLabel[2][1];
	ShowTurn(char x){
		if(counter%2==0){
		    if(Player1.color==1){
			disk4[0][0].setForeground(Color.black);
			disk4[1][0].setForeground(Color.green);
			counter++;
		}
		    else if(Player2.color==1){
			disk4[1][0].setForeground(Color.black);
			disk4[0][0].setForeground(Color.green);
			counter++;
		}
		}
		else if(counter%2!=0){
			if(Player1.color==2){
			disk4[0][0].setForeground(Color.black);
			disk4[1][0].setForeground(Color.green);
			counter++;
		}
		    else if(Player2.color==2){
			disk4[1][0].setForeground(Color.black);
			disk4[0][0].setForeground(Color.green);
			counter++;
		  }
	  }
	}
	ShowTurn(int x){
		if(counter%2==0){
		    if(Player1.color==1){
			disk4[0][0].setForeground(Color.green);
			disk4[1][0].setForeground(Color.black);
			counter++;
		}
		    else if(Player2.color==1){
			disk4[1][0].setForeground(Color.green);
			disk4[0][0].setForeground(Color.black);
			counter++;
		}
		}
		else if(counter%2!=0){
			if(Player1.color==2){
			disk4[0][0].setForeground(Color.green);
			disk4[1][0].setForeground(Color.black);
			counter++;
		}
		    else if(Player2.color==2){
			disk4[1][0].setForeground(Color.green);
			disk4[0][0].setForeground(Color.black);
			counter++;
		}
	}
	}
	ShowTurn(){
		super("Turn");
		setSize(100, 500);
		setLocation(1032, 50);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().add(jp);
		jp.setBackground(Color.white);
		for (int i = 0; i < 2; i++){
				disk4[i][0] = new JLabel("\u2022", SwingConstants.CENTER);
				jp.add(disk4[i][0]);
				disk4[i][0].setForeground(Color.black);
				disk4[i][0].setOpaque(true);
				disk4[i][0].setBackground(Color.black);
				disk4[i][0].setFont(new Font("Arial", Font.PLAIN, 90));
		}
		disk4[0][0].setText(disk4[0][0].getText()+"P1");
		disk4[0][0].setForeground(Color.black);
		disk4[1][0].setText(disk4[1][0].getText()+"P2");
		disk4[1][0].setForeground(Color.black);
		if(counter%2==0){
		if(Player1.color==1){
			disk4[0][0].setForeground(Color.green);
			disk4[1][0].setForeground(Color.black);
			counter++;
		}
		else if(Player2.color==1){
			disk4[1][0].setForeground(Color.green);
			disk4[0][0].setForeground(Color.black);
			counter++;
		}
		}
		else if(counter%2!=0){
			if(Player1.color==2){
			disk4[0][0].setForeground(Color.green);
			disk4[1][0].setForeground(Color.black);
			counter++;
		}
		else if(Player2.color==2){
			disk4[1][0].setForeground(Color.green);
			disk4[0][0].setForeground(Color.black);
			counter++;
		}
		}
	setVisible(true);
	}
}
class TimerTotal implements Runnable{

	@Override
	public void run() {
		try {
			JFrame jf = new JFrame("Time");
			JPanel jp = new JPanel();
			JTextArea jta1 = new JTextArea();
			JTextArea jta2 = new JTextArea();
			JTextArea jta3 = new JTextArea();
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.setSize(100, 100);
			jf.setLocation(700, 543);
			jf.setForeground(Color.white);
			jf.setBackground(Color.white);
			jf.setVisible(true);
			jf.getContentPane().add(jp);
			for(int i=0;i<10;i++) {
				for(int j=0;j<=59;j++) {
					jp.add(jta1);
					jp.add(jta2);
					jp.add(jta3);					
					jta1.setText(i+"");
					jta2.setText(":");
					jta3.setText(j+"");
					jta1.setVisible(true);
					jta2.setVisible(true);
					jta3.setVisible(true);
					Thread.sleep(1000);					
				}
			}
		}catch(InterruptedException e) {
			System.out.print("Exception");
		}
		
	}	
}
class Save{
	Save(){
		StringBuilder builder = new StringBuilder();
        for(int i = 0; i < 8; i++){//for each row
           for(int j = 0; j < 8; j++){//for each column
               builder.append(Intdisk.disk[i][j]+"");//append to the output string
               if(j < Intdisk.disk.length - 1)//if this is not the last row element
               builder.append(" ");//then add space
       }
            builder.append("\n");//append new line at the end of the row
    }
        BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("/d:" + "Othello.txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//saving the string representation of the Intdisk.disk
        try {
			writer.write(builder.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
        try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
class SaveAs{
	String userstr;
	SaveAs(){
		Scanner input=new Scanner(System.in);
		userstr=input.next();
				StringBuilder builder = new StringBuilder();
        for(int i = 0; i < 8; i++){//for each row
           for(int j = 0; j < 8; j++){//for each column
               builder.append(Intdisk.disk[i][j]+"");//append to the output string
               if(j < Intdisk.disk.length - 1)//if this is not the last row element
               builder.append(" ");//then add space
       }
            builder.append("\n");//append new line at the end of the row
    }
        BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("/d:" + userstr+"txt"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		//saving the string representation of the Intdisk.disk
        try {
			writer.write(builder.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
        try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
/*class Open{
	Open(){
        BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("D:\\Othello.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
        String line = "";
        int row = 0;
        try {
			while((line = reader.readLine()) != null){
			String[] cols = line.split(" ");
			int col = 0;
			for(String  c : cols){
			  Intdisk.disk[row][col] = Integer.parseInt(c);
			  col++;
			}
			  row++;
     }
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
      try {
		reader.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}*/
public class Othello {
	public static void main(String[] args) {
		new MainBoard();
		new Intializer();
		new ButtonMaker();
		new ShowTurn();
		new FindTurn();
		Thread thread = new Thread(new TimerTotal());
		thread.start();
		
	}
}
