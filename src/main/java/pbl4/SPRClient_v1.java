package pbl4;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.*;
import static java.lang.Math.abs;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SPRClient_v1 extends javax.swing.JFrame {
    int numVer;
    
    Socket soc;
    DataInputStream dis;
    DataOutputStream dos;
    File file;
    
    String[] E_V;
    List<Edge> matrix;
    
    List<Point> pClicked;
    Graphics g;
    
    public SPRClient_v1() {
        initComponents();
        CBBFile();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnDrawPath = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbbFile = new javax.swing.JComboBox<>();
        btnInsertFile = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        taMatrix = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        taListShortestPath = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tfpStart = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfpEnd = new javax.swing.JTextField();
        btnCalculate = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        tfShortestDistance = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfShortestPath = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnDrawGraph = new javax.swing.JButton();
        btnClearAll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Shortest Path Routing");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setResizable(false);

        pnDrawPath.setBackground(new java.awt.Color(255, 255, 255));
        pnDrawPath.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnDrawPath.setForeground(new java.awt.Color(255, 255, 255));
        pnDrawPath.setAutoscrolls(true);
        pnDrawPath.setEnabled(false);
        pnDrawPath.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnDrawPathMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnDrawPathLayout = new javax.swing.GroupLayout(pnDrawPath);
        pnDrawPath.setLayout(pnDrawPathLayout);
        pnDrawPathLayout.setHorizontalGroup(
            pnDrawPathLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
        );
        pnDrawPathLayout.setVerticalGroup(
            pnDrawPathLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setText("Select File");

        cbbFile.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbbFile.setBorder(null);
        cbbFile.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnInsertFile.setBackground(new java.awt.Color(153, 153, 255));
        btnInsertFile.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnInsertFile.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertFile.setText("Insert Info File");
        btnInsertFile.setBorderPainted(false);
        btnInsertFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertFileActionPerformed(evt);
            }
        });

        taMatrix.setColumns(18);
        taMatrix.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        taMatrix.setRows(5);
        taMatrix.setTabSize(6);
        jScrollPane1.setViewportView(taMatrix);

        taListShortestPath.setColumns(20);
        taListShortestPath.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        taListShortestPath.setRows(6);
        taListShortestPath.setTabSize(6);
        jScrollPane2.setViewportView(taListShortestPath);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Point Start");

        jLabel3.setText("Point End");

        btnCalculate.setBackground(new java.awt.Color(153, 153, 255));
        btnCalculate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnCalculate.setForeground(new java.awt.Color(255, 255, 255));
        btnCalculate.setText(" Calculate");
        btnCalculate.setAutoscrolls(true);
        btnCalculate.setBorderPainted(false);
        btnCalculate.setEnabled(false);
        btnCalculate.setOpaque(true);
        btnCalculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalculateActionPerformed(evt);
            }
        });

        jLabel4.setText(" Shortest Distance");

        jLabel5.setText("Shortest Path");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfpStart, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(tfpEnd)))
                    .addComponent(btnCalculate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfShortestPath)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(24, 24, 24)))
                        .addGap(56, 56, 56))
                    .addComponent(tfShortestDistance, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(88, 88, 88))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tfpStart))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(tfpEnd))
                        .addGap(25, 25, 25)
                        .addComponent(btnCalculate)
                        .addGap(9, 9, 9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(4, 4, 4)
                        .addComponent(tfShortestDistance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfShortestPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Shortest Path Routing Program");
        jLabel6.setOpaque(true);

        btnDrawGraph.setBackground(new java.awt.Color(153, 153, 255));
        btnDrawGraph.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDrawGraph.setForeground(new java.awt.Color(255, 255, 255));
        btnDrawGraph.setText("Draw");
        btnDrawGraph.setToolTipText("");
        btnDrawGraph.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnDrawGraph.setBorderPainted(false);
        btnDrawGraph.setEnabled(false);
        btnDrawGraph.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDrawGraphActionPerformed(evt);
            }
        });

        btnClearAll.setBackground(new java.awt.Color(153, 153, 255));
        btnClearAll.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnClearAll.setForeground(new java.awt.Color(255, 255, 255));
        btnClearAll.setText("Clear All");
        btnClearAll.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnClearAll.setBorderPainted(false);
        btnClearAll.setEnabled(false);
        btnClearAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearAllActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnInsertFile, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 253, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnDrawPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbFile, 0, 169, Short.MAX_VALUE)
                                .addGap(558, 558, 558)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnClearAll, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDrawGraph, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(btnDrawGraph, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClearAll, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(cbbFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnInsertFile, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
                            .addComponent(pnDrawPath, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //tao combo box file
    public void CBBFile(){
        File folder = new File("Matrix");
        String[] listFile = folder.list();
        
        for (String str : listFile) {
            cbbFile.addItem(str);
        }
    }
    
    //ham khoi tao
    public void Initialize() {
        taMatrix.setText("");
        taListShortestPath.setText("");
        tfShortestDistance.setText("");
        tfShortestPath.setText("");
        tfpEnd.setText("");
        tfpStart.setText("");
        
        pnDrawPath.setEnabled(true); 
        btnDrawGraph.setEnabled(true);
        btnClearAll.setEnabled(true);
//        tbtnClearPoint.setEnabled(true);
        btnCalculate.setEnabled(true);
        
        g = pnDrawPath.getGraphics();
        pClicked = new ArrayList();
        
        g.clearRect(0, 0, pnDrawPath.getWidth(), pnDrawPath.getHeight());
        pClicked.clear();
    }
    
    //ham doc file
    public boolean ReadFile(String nameFile) throws Exception {
        file = new File("Matrix/" + nameFile);
        InputStream is = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        try {
            String line = br.readLine();
        
            E_V = line.split(" ");

            dos.writeInt(Integer.parseInt(E_V[0]));
            dos.writeInt(Integer.parseInt(E_V[1]));
            numVer = Integer.parseInt(E_V[1]);

            taMatrix.append("Num of edge : "+ E_V[0] + "\n");
            taMatrix.append("Num of ver   : "+ E_V[1] + "\n");

            taMatrix.append("Matrix : \n");

            int src, dest, wei;
            matrix = new ArrayList();
            
            line = br.readLine();
            while(line != null) {
                String[] edge = line.split(" ");
                
                src = Integer.parseInt(edge[0]);
                dest = Integer.parseInt(edge[1]);
                wei = Integer.parseInt(edge[2]);
                matrix.add(new Edge(src, dest, wei));
                
                dos.writeInt(src);
                dos.writeInt(dest);
                dos.writeInt(wei);
                
                
                taMatrix.append(edge[0] +"\t" + edge[1] + "\t" + edge[2] + "\n");

                line = br.readLine();
            }
            return CheckMatrix(matrix);
        } catch (Exception e) {
            return false;
        }
        
    }
    
    //kiem tra mang dua vao co hop le
    public boolean CheckMatrix(List<Edge> matrix) {
        //Kiem tra so dinh phai bang chi so cao nhat cua dinh
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(Edge e : matrix) {
            if(max < e.destination) max = e.destination;
            if(min > e.source) min = e.source;
        }
        
        int numE = Integer.parseInt(E_V[0]);
        int numV = Integer.parseInt(E_V[1]);

        if(Integer.parseInt(E_V[1]) < max) return false;
        
        //Kiem tra so diem phu hop so cach
        int dem = 0;
        for(Edge e : matrix) {
            if(e.destination == max && e.source == min 
                    || e.destination == min && e.source == max) {
                dem++;
            }
        }
        
        if(numE == 1 && numV == 2) 
        {
            if(dem != 1) return false;
            else return true;
        }
        
        if(dem == 1) {
            if(numE > numV*(numV - 1 )/2 || numE < numV) return false;
        } else {
            if(numE > numV) return false;
        }
        
        //kiem tra so canh dua vao
        if(matrix.size() != Integer.parseInt(E_V[0])) return false;
        
        //kiem tra chi so diem
        for(Edge i : matrix) {
            if(!i.CheckEdge()) return false;
            
            int count = 0;
            for(Edge j : matrix) {
                if(i.equalsEdge(j)) count++;
            }
            
            if(count > 1) return false;
        }
        return true;
    }
    
    private void btnInsertFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertFileActionPerformed
        try {
            soc = new Socket("localhost", 5000);
            dos = new DataOutputStream(soc.getOutputStream());
            dis = new DataInputStream(soc.getInputStream());
            
            String nameFile = cbbFile.getItemAt(cbbFile.getSelectedIndex());
            Initialize();
            
            //neu file loi ngat ket noi
            if(!ReadFile(nameFile)) {
                taMatrix.setText("");
                int yes = JOptionPane.showConfirmDialog(
                        rootPane, "The data in the file is incorrect !\n"
                        + "Do you want to edit the data in the file ?",
                        "File Error", JOptionPane.YES_NO_OPTION);
                if(yes == JOptionPane.YES_OPTION) {
                    Desktop des = Desktop.getDesktop();
                    des.open(file);
                }
                E_V = null;
                soc.close();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, "Connection to server failed !");
        }
    }//GEN-LAST:event_btnInsertFileActionPerformed
    
    //ve diem
    public void DrawPoint(int index, Point point) {
        g.setColor(Color.BLACK);
        g.fillOval(point.x - 12, point.y - 12, 24, 24);
        
        g.setColor(Color.BLUE);
        Graphics2D g2D = (Graphics2D) g;
        BasicStroke bs = new BasicStroke(3, BasicStroke.CAP_ROUND, 
                                BasicStroke.JOIN_ROUND);
        g2D.setStroke(bs);
        g2D.drawOval(point.x - 12, point.y - 12, 25, 25);
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 12));
        g.drawString(index + "", point.x - 3, point.y + 5);
    }
    
    //ve canh
    public void DrawEdge(int src, int dest, String wei) {
        Point pSrc = pClicked.get(src);
        Point pDest = pClicked.get(dest);
        g.setColor(Color.BLACK);
        g.drawLine(pSrc.x, pSrc.y, pDest.x, pDest.y);
        g.drawString(wei, (pSrc.x + pDest.x)/2 - 10, (pSrc.y + pDest.y)/2 - 10);

        DrawPoint(src + 1, pSrc);
        DrawPoint(dest + 1, pDest);
        }
    
    //ve do thi
    public void DrawGraph() {
        try {             
                InputStream is = new FileInputStream(file);
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader br = new BufferedReader(isr);
                
                String line = br.readLine();
                
                int src, dest;
                String wei;

                while(line != null) {
                    line = br.readLine();
                    String[] edge = line.split(" ");

                    src = Integer.parseInt(edge[0]) - 1;
                    dest = Integer.parseInt(edge[1]) - 1;
                    wei = edge[2];
                    DrawEdge(src, dest, wei);
            }
            
        } catch (Exception e) {}
    }
    //ham ve duong di ngan nhat
    public void DrawLineShortestPath(String line, int lengthTitle) {
        
        String subLine = line.substring(lengthTitle);
        
        //mang ghi ra cac diem thuoc duong di ngan nhat
        String[] pointSP = subLine.split("-->");
        
        for(int i = 0; i < pointSP.length - 1; i++) {
            int indexSrc = Integer.parseInt(pointSP[i]) - 1;
            int indexDest = Integer.parseInt(pointSP[i + 1]) - 1;
            DrawEdge(indexSrc, indexDest, "");
        }
        
        for(int i = 0; i < pointSP.length - 1; i++) {
            int indexSrc = Integer.parseInt(pointSP[i]) - 1;
            int indexDest = Integer.parseInt(pointSP[i + 1]) - 1;
            
            //12 la ban kinh cua diem ve
            g.setColor(Color.RED);
            g.drawLine(pClicked.get(indexSrc).x, pClicked.get(indexSrc).y, 
                    pClicked.get(indexDest).x, pClicked.get(indexDest).y);
            
            //ve lai diem
            DrawPoint(indexSrc + 1, pClicked.get(indexSrc));
            DrawPoint(indexDest + 1, pClicked.get(indexDest));
        }
    }
    private void btnCalculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalculateActionPerformed
        try {              
            taListShortestPath.setText("");
            int pStart = Integer.parseInt(tfpStart.getText()) - 1;
            int pEnd = Integer.parseInt(tfpEnd.getText()) - 1;
            
            int max = 0;
            int min = Integer.MAX_VALUE;
            for(Edge e : matrix) {
                if(max < e.destination - 1) max = e.destination -1;
                if(min > e.source - 1) min = e.source - 1;
            }
            
            if(pStart <= max && pStart >= min && pEnd <= max && pEnd >= min) {
                dos.writeInt(pStart);
                dos.writeInt(pEnd);
                tfShortestDistance.setText(dis.readInt() + "");

                String shortestPath = dis.readUTF();
                tfShortestPath.setText(shortestPath);

                int lengthTitle = dis.readInt();
                if(!pClicked.isEmpty()) {
                    DrawGraph();
                    DrawLineShortestPath(shortestPath, lengthTitle);
                }

                int n = dis.readInt();
                for(int i = 0; i < n; i++){
                   taListShortestPath.append(dis.readUTF());
                }     
            } else {
                JOptionPane.showMessageDialog(rootPane, "Input Point Error ! Please Input Again");
                tfShortestDistance.setText("");
                tfShortestPath.setText("");
            }
            
            
        } catch (IOException ex) {}
    }//GEN-LAST:event_btnCalculateActionPerformed
    
    private void pnDrawPathMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnDrawPathMouseClicked
        if(E_V != null) {
            if(pnDrawPath.isEnabled() && pClicked.size() < Integer.parseInt(E_V[1])) {
                Point p = new Point(evt.getPoint());
                int i = 0;
                int count = 0;

                for(i = 0; i < pClicked.size(); i++) {
                    if(abs(pClicked.get(i).x - p.x) <= 50 && abs(pClicked.get(i).y - p.y) <= 50) {
                        count++;
                    }
                }
                
                if(count == 0) {
                    DrawPoint(i + 1, p);
                    pClicked.add(p);
                }
            }
        }
    }//GEN-LAST:event_pnDrawPathMouseClicked

    private void btnClearAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearAllActionPerformed
        g.clearRect(0, 0, pnDrawPath.getWidth(), pnDrawPath.getHeight());
        pClicked.clear();
    }//GEN-LAST:event_btnClearAllActionPerformed

    private void btnDrawGraphActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDrawGraphActionPerformed
        if(pClicked.size() == Integer.parseInt(E_V[1])) {
              //tbtnClearPoint.setEnabled(false);
              DrawGraph();
        }     
    }//GEN-LAST:event_btnDrawGraphActionPerformed
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SPRClient_v1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCalculate;
    private javax.swing.JButton btnClearAll;
    private javax.swing.JButton btnDrawGraph;
    private javax.swing.JButton btnInsertFile;
    private javax.swing.JComboBox<String> cbbFile;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel pnDrawPath;
    private javax.swing.JTextArea taListShortestPath;
    private javax.swing.JTextArea taMatrix;
    private javax.swing.JTextField tfShortestDistance;
    private javax.swing.JTextField tfShortestPath;
    private javax.swing.JTextField tfpEnd;
    private javax.swing.JTextField tfpStart;
    // End of variables declaration//GEN-END:variables
}
