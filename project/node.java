import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.text.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class node<T> extends Pane{
   private T element;
   private int index;
   Line[] walls = new Line[4];
   Line[] topArrow = new Line[3];
   Line[] bottomArrow = new Line[3];
   Rectangle capa = new Rectangle();
   Text texto;
   Text highText;
   Text lowText;
   Text pivotText;
   
   node(T e){
      this.element = e;
      
      setPrefSize(35,260);
      
      topArrow[0] = new Line(this.getWidth()/2,this.getHeight()*2/10,this.getWidth()/2,this.getHeight()*4.45/10);
      topArrow[0].startXProperty().bind(this.widthProperty().divide(2));
      topArrow[0].startYProperty().bind(this.heightProperty().multiply(2).divide(10));
      topArrow[0].endXProperty().bind(this.widthProperty().divide(2));
      topArrow[0].endYProperty().bind(this.heightProperty().multiply(4.45).divide(10));
      
      topArrow[1] = new Line(this.getWidth()/2,this.getHeight()*4.45/10,this.getWidth()*2/3,this.getHeight()*3.95/10);
      topArrow[1].startXProperty().bind(this.widthProperty().divide(2));
      topArrow[1].startYProperty().bind(this.heightProperty().multiply(4.45).divide(10));
      topArrow[1].endXProperty().bind(this.widthProperty().multiply(2).divide(3));
      topArrow[1].endYProperty().bind(this.heightProperty().multiply(3.95).divide(10));
      
      topArrow[2] = new Line(this.getWidth()/2,this.getHeight()*4.45/10,this.getWidth()/3,this.getHeight()*3.95/10);
      topArrow[2].startXProperty().bind(this.widthProperty().divide(2));
      topArrow[2].startYProperty().bind(this.heightProperty().multiply(4.45).divide(10));
      topArrow[2].endXProperty().bind(this.widthProperty().divide(3));
      topArrow[2].endYProperty().bind(this.heightProperty().multiply(3.95).divide(10));
      
      for(int i=0;i<3;i++){
         getChildren().add(topArrow[i]);
      }
   
      walls[0] = new Line(0, this.getHeight()*5/10, this.getWidth(),this.getHeight()*5/10);
      walls[0].endXProperty().bind(this.widthProperty());
      walls[0].startYProperty().bind(this.heightProperty().multiply(5).divide(10));
      walls[0].endYProperty().bind(this.heightProperty().multiply(5).divide(10));
   
      walls[1] = new Line(this.getWidth(), this.getHeight()*5/10, this.getWidth(), this.getHeight()*6.5/10);
      walls[1].startXProperty().bind(this.widthProperty());
      walls[1].startYProperty().bind(this.heightProperty().multiply(5).divide(10));
      walls[1].endXProperty().bind(this.widthProperty());
      walls[1].endYProperty().bind(this.heightProperty().multiply(6.5).divide(10));
      
      walls[2] = new Line(0, this.getHeight()*6.5/10, this.getWidth(), this.getHeight()*6.5/10);
      walls[2].startYProperty().bind(this.heightProperty().multiply(6.5).divide(10));
      walls[2].endXProperty().bind(this.widthProperty());
      walls[2].endYProperty().bind(this.heightProperty().multiply(6.5).divide(10));
   
      walls[3] = new Line(0, this.getHeight()*5/10, 0, this.getHeight()*6.5/10);
      walls[3].startYProperty().bind(this.heightProperty().multiply(5).divide(10));
      walls[3].endYProperty().bind(this.heightProperty().multiply(6.5).divide(10));
      
      for(int i=0;i<4;i++){
         getChildren().add(walls[i]);
      }
      
      capa.setX(0);
      capa.setY(this.getHeight()*5/10);
      capa.yProperty().bind(this.heightProperty().multiply(5).divide(10));
      capa.setWidth(this.getWidth());
      capa.widthProperty().bind(this.widthProperty());
      capa.setHeight(this.getHeight()*1.5/10);
      capa.heightProperty().bind(this.heightProperty().multiply(1.5).divide(10));
      capa.setFill(Color.WHITE);
      
      getChildren().add(capa);
      
      texto = new Text(this.getWidth()/2-10,this.getHeight()*5.9/10,element.toString());
      texto.xProperty().bind(this.widthProperty().divide(2).subtract(10));
      texto.yProperty().bind(this.heightProperty().multiply(5.9).divide(10));
      
      highText = new Text(this.getWidth()/10,this.getHeight()/10,"high");
      highText.xProperty().bind(this.widthProperty().divide(10));
      highText.yProperty().bind(this.heightProperty().divide(10));
      highText.setFont(Font.font ("Verdana", 10));
      
      lowText = new Text(this.getWidth()/10,this.getHeight()*1.7/10,"low");
      lowText.xProperty().bind(this.widthProperty().divide(10));
      lowText.yProperty().bind(this.heightProperty().multiply(1.7).divide(10));
      lowText.setFont(Font.font ("Verdana", 10));
      
      pivotText = new Text(0,this.getHeight()*9.5/10,"pivot");
      pivotText.yProperty().bind(this.heightProperty().multiply(9.5).divide(10));
      pivotText.setFont(Font.font ("Verdana", 10));
      
      this.getChildren().addAll(texto,highText,lowText,pivotText);
      
      bottomArrow[0] = new Line(this.getWidth()/2,this.getHeight()*7/10,this.getWidth()/2,this.getHeight()*9/10);
      bottomArrow[0].startXProperty().bind(this.widthProperty().divide(2));
      bottomArrow[0].startYProperty().bind(this.heightProperty().multiply(7).divide(10));
      bottomArrow[0].endXProperty().bind(this.widthProperty().divide(2));
      bottomArrow[0].endYProperty().bind(this.heightProperty().multiply(9).divide(10));
      
      bottomArrow[1] = new Line(this.getWidth()/2,this.getHeight()*7/10,this.getWidth()*2/3,this.getHeight()*7.5/10);
      bottomArrow[1].startXProperty().bind(this.widthProperty().divide(2));
      bottomArrow[1].startYProperty().bind(this.heightProperty().multiply(7).divide(10));
      bottomArrow[1].endXProperty().bind(this.widthProperty().multiply(2).divide(3));
      bottomArrow[1].endYProperty().bind(this.heightProperty().multiply(7.5).divide(10));
      
      bottomArrow[2] = new Line(this.getWidth()/2,this.getHeight()*7/10,this.getWidth()/3,this.getHeight()*7.5/10);
      bottomArrow[2].startXProperty().bind(this.widthProperty().divide(2));
      bottomArrow[2].startYProperty().bind(this.heightProperty().multiply(7).divide(10));
      bottomArrow[2].endXProperty().bind(this.widthProperty().divide(3));
      bottomArrow[2].endYProperty().bind(this.heightProperty().multiply(7.5).divide(10));
      
      for(int i=0;i<3;i++){
         getChildren().add(bottomArrow[i]);
      }

            
   }
   
   public void setElement(T o){
      element = o;
   }
   
   public T getElement(){
      return element;
   }
   
   public void borrarTopArrow(){
      for(int i=0;i<3;i++){
         topArrow[i].setStroke(Color.WHITE);
      }
   }
   
   public void pintarTopArrow(){
      for(int i=0;i<3;i++){
         topArrow[i].setStroke(Color.BLACK);
      }
      pivotText.setFill(Color.BLACK);
   }
   
   public void borrarBottomArrow(){
      for(int i=0;i<3;i++){
         bottomArrow[i].setStroke(Color.WHITE);
      }
      pivotText.setFill(Color.WHITE);
   }
   
   public void pintarBottomArrow(){
      for(int i=0;i<3;i++){
         bottomArrow[i].setStroke(Color.BLACK);
      }
      
   }
   
   public void background() {
      capa.setFill(Color.SKYBLUE);
   }
   
   public void setBackgroundWhite() {
      capa.setFill(Color.WHITE);
   }
   
   public void pintarHigh(){
      highText.setFill(Color.BLACK);
   }
   
   public void borrarHigh(){
      highText.setFill(Color.WHITE);
   }
   
   public void pintarLow(){
      lowText.setFill(Color.BLACK);
   }
   
   public void borrarLow(){
      lowText.setFill(Color.WHITE);
   }
   
}
