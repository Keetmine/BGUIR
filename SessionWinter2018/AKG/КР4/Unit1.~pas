unit Unit1;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics,
  Controls, Forms, Dialogs, StdCtrls, Buttons, ComCtrls,
  ExtCtrls;

type
  TForm1 = class(TForm)
    Label1: TLabel;
    Label2: TLabel;
    Label3: TLabel;
    Panel1: TPanel;
    Image1: TImage;
    EditX: TEdit;
    EditY: TEdit;
    EditZ: TEdit;
    Xbtn0: TSpeedButton;
    Ybtn0: TSpeedButton;
    Zbtn0: TSpeedButton;
    RadioButton1: TRadioButton;
    RadioButton2: TRadioButton;
    ProjectionBox: TCheckBox;
    RevolverBtn: TSpeedButton;
    TrackBarX: TTrackBar;
    TrackBarY: TTrackBar;
    TrackBarZ: TTrackBar;

    procedure FormCreate(Sender: TObject);
    procedure TrackBarXChange(Sender: TObject);
    procedure TrackBarYChange(Sender: TObject);
    procedure TrackBarZChange(Sender: TObject);
    procedure Xbtn0Click(Sender: TObject);
    procedure Ybtn0Click(Sender: TObject);
    procedure Zbtn0Click(Sender: TObject);
    procedure MakeIsoMatrix(Sender: TObject);
    procedure MakeCoordAxes(Sender: TObject);
    procedure PaintCoordAxes(Sender: TObject);
    procedure CalcPrism(Sender: TObject);
    procedure PaintKarkas(Sender: TObject);
    procedure ViewProjection(Sender: TObject);
    procedure ProjectionBoxClick(Sender: TObject);
    procedure CalcProjection(Sender: TObject);
    procedure RevolverBtnClick(Sender: TObject);
    procedure TestGranVis(Sender: TObject);
    procedure TestRebroVis(Sender: TObject);
    procedure RadioButton2Click(Sender: TObject);
    procedure RadioButton1Click(Sender: TObject);

  private
    { Private declarations }
  public
    { Public declarations }
  end;

type
  TPoint = record         // точка в 3D-пространстве
    x: integer;
    y: integer;
    z: integer;
    end;

  TRebro = record         // ребро с начальной и конечной точкой 3D
    b: TPoint;
    e: TPoint;
  end;

  TTochka = record        // точка экрана
    x: integer;
    y: integer;
    end;

  TRebroEkran = record    // ребро с начальной и конечной точкой на экране
    b: TTochka;
    e: TTochka;
  end;

var
  Form1: TForm1;
  Fi, Teta, Psi: integer;
  AxesCoord: array [1..3] of TPoint;
  IsoMatrix: array [1..3] of array [1..3] of double;
  CoordAxes: array [1..9] of TPoint;
  PointsArr: array [1..12] of TPoint;
  RebroArr: array [1..18] of TRebro;
  RebroEkranArr: array [1..18] of TRebroEkran;
  XYArr: array [1..18] of TRebro;
  YZArr: array [1..18] of TRebro;
  ZXArr: array [1..18] of TRebro;
  Gran: array [1..8] of array of integer;
  GranVis: array [1..8] of boolean;
  RebroVis: array [1..18] of boolean;

const
  x0 = 270;          // координаты центра плоскости проекции (экрана)
  y0 = 270;

implementation


{$R *.dfm}

{*****  ф-ия преобразования 3D-координат точки в точку экрана  ******}
function Reform(p:TPoint): TTochka;
{********************************************************************}
begin
  Reform.x:=x0 + Round(p.x*IsoMatrix[1][1]+p.z*IsoMatrix[2][1]+p.y*IsoMatrix[3][1]);
  Reform.y:=y0 + Round(p.x*IsoMatrix[1][2]+p.z*IsoMatrix[2][2]+p.y*IsoMatrix[3][2]);
end;

{*******************  Готовим матрицу отображения  ******************}
procedure TForm1.MakeIsoMatrix(Sender: TObject);
{********************************************************************}
begin
  IsoMatrix[1][1]:= -sqrt(1/2);             // cos b          // стр.1 столб.1
  IsoMatrix[1][2]:= sqrt(1/2)*sqrt(1/3);    // sin a sin b    // стр.1 столб.2
  IsoMatrix[1][3]:= 0;                      // 0              // стр.1 столб.3
  IsoMatrix[2][1]:= 0;                      // 0              // стр.2 столб.1
  IsoMatrix[2][2]:= -sqrt(2/3);             // cos a          // стр.2 столб.2
  IsoMatrix[2][3]:= 0;                      // 0              // стр.2 столб.3
  IsoMatrix[3][1]:= sqrt(1/2);              // sin b          // стр.3 столб.1
  IsoMatrix[3][2]:= sqrt(1/2)*sqrt(1/3);    // - sin a cos b  // стр.3 столб.2
  IsoMatrix[3][3]:= 0;                      // 0              // стр.3 столб.3
end;

{******************  Готовим оси координат  **************************}
procedure TForm1.MakeCoordAxes(Sender: TObject);
{********************************************************************}
begin
  CoordAxes[1].x:= 0;
  CoordAxes[1].y:= 0;
  CoordAxes[1].z:= 0;
  CoordAxes[2].x:= 0;
  CoordAxes[2].y:= 0;
  CoordAxes[2].z:= 220;                                        // ось Z
  CoordAxes[3].x:= 0;
  CoordAxes[3].y:= 0;
  CoordAxes[3].z:= 0;
  CoordAxes[4].x:= 220;                                        // ось X
  CoordAxes[4].y:= 0;
  CoordAxes[4].z:= 0;
  CoordAxes[5].x:= 0;
  CoordAxes[5].y:= 0;
  CoordAxes[5].z:= 0;
  CoordAxes[6].x:= 0;
  CoordAxes[6].y:= 220;                                        // ось Y
  CoordAxes[6].z:= 0;
  CoordAxes[7].x:= 0;
  CoordAxes[7].y:= 0;
  CoordAxes[7].z:= 230;
  CoordAxes[8].x:= 230;
  CoordAxes[8].y:= 0;
  CoordAxes[8].z:= 0;
  CoordAxes[9].x:= 0;
  CoordAxes[9].y:= 230;
  CoordAxes[9].z:= 0;
end;

{******************  Рисуем оси координат  **************************}
procedure TForm1.PaintCoordAxes(Sender: TObject);
{********************************************************************}
begin
  Image1.Canvas.Pen.Color:= clBlack;
  Image1.Canvas.MoveTo(Reform(CoordAxes[1]).x,Reform(CoordAxes[1]).y);
  Image1.Canvas.LineTo(Reform(CoordAxes[2]).x,Reform(CoordAxes[2]).y);
  Image1.Canvas.MoveTo(Reform(CoordAxes[3]).x,Reform(CoordAxes[3]).y);
  Image1.Canvas.LineTo(Reform(CoordAxes[4]).x,Reform(CoordAxes[4]).y);
  Image1.Canvas.MoveTo(Reform(CoordAxes[5]).x,Reform(CoordAxes[5]).y);
  Image1.Canvas.LineTo(Reform(CoordAxes[6]).x,Reform(CoordAxes[6]).y);
  Image1.Canvas.TextOut(Reform(CoordAxes[7]).x,Reform(CoordAxes[7]).y,'Z');
  Image1.Canvas.TextOut(Reform(CoordAxes[8]).x,Reform(CoordAxes[8]).y,'X');
  Image1.Canvas.TextOut(Reform(CoordAxes[9]).x,Reform(CoordAxes[9]).y,'Y');
end;

{****************  Начальная подготовка  ****************************}
procedure TForm1.FormCreate(Sender: TObject);
{********************************************************************}
begin
  Image1.Canvas.Brush.Color:= clWhite;           // готовим
  Image1.Canvas.FillRect(Image1.ClientRect);     // поле
  Image1.Canvas.Pen.Color:= clBlack;             // для рисования
  MakeIsoMatrix(Sender);
  MakeCoordAxes(Sender);
  PaintCoordAxes(Sender);
  CalcPrism(Sender);
  CalcProjection(Sender);
  TestGranVis(Sender);
  TestRebroVis(Sender);
  PaintKarkas(Sender);
end;

{****************  Расчет шестигранный призмы  **********************}
procedure TForm1.CalcPrism(Sender: TObject);
{********************************************************************}
var
  i: integer;
  TempArr: array [1..12] of TPoint;
begin
  for i:=1 to 6 do
  begin
    PointsArr[i].x:= 80 + Round(60*cos(-Pi/3-2*Pi*i/6));
    PointsArr[i].y:= 80 + Round(60*sin(-Pi/3-2*Pi*i/6));
    PointsArr[i].z:= 20;                        // нижнее основание
    PointsArr[i+6].x:= 80 + Round(60*cos(-Pi/3-2*Pi*i/6));
    PointsArr[i+6].y:= 80 + Round(60*sin(-Pi/3-2*Pi*i/6));
    PointsArr[i+6].z:= 200;                       // верхнее основание
  end;

  if Fi <> 0 then
  begin
    for i:=1 to 12 do
    begin
      TempArr[i].x:= PointsArr[i].x;
      TempArr[i].y:= Round(PointsArr[i].y*cos(Fi*Pi/180)+PointsArr[i].z*(-sin(Fi*Pi/180)));
      TempArr[i].z:= Round(PointsArr[i].y*sin(Fi*Pi/180)+PointsArr[i].z*cos(Fi*Pi/180));
    end;
    for i:=1 to 12 do
     PointsArr[i]:= TempArr[i];
  end;

  if Teta <> 0 then
  begin
    for i:=1 to 12 do
    begin
      TempArr[i].x:= Round(PointsArr[i].x*cos(Teta*Pi/180)+PointsArr[i].z*sin(Teta*Pi/180));
      TempArr[i].y:= PointsArr[i].y;
      TempArr[i].z:= Round(PointsArr[i].x*(-sin(Teta*Pi/180))+PointsArr[i].z*cos(Teta*Pi/180));
    end;
    for i:=1 to 12 do
     PointsArr[i]:= TempArr[i];
  end;

  if Psi <> 0 then
  begin
    for i:=1 to 12 do
    begin
      TempArr[i].x:= Round(PointsArr[i].x*cos(Psi*Pi/180)+PointsArr[i].y*(-sin(Psi*Pi/180)));
      TempArr[i].y:= Round(PointsArr[i].x*sin(Psi*Pi/180)+PointsArr[i].y*cos(Psi*Pi/180));
      TempArr[i].z:= PointsArr[i].z;
    end;
    for i:=1 to 12 do
     PointsArr[i]:= TempArr[i];
  end;

  for i:=1 to 5 do
  begin
    RebroArr[i].b:= PointsArr[i];
    RebroArr[i].e:= PointsArr[i+1];
    RebroArr[i+6].b:= PointsArr[i+6];
    RebroArr[i+6].e:= PointsArr[i+7];
  end;
  RebroArr[6].b:= PointsArr[6];              // ребра 1..6 = нижнее основание
  RebroArr[6].e:= PointsArr[1];
  RebroArr[12].b:= PointsArr[12];
  RebroArr[12].e:= PointsArr[7];             // ребра 7..12 = верхнее основание
  for i:=1 to 6 do
  begin
    RebroArr[i+12].b:= PointsArr[i];         // ребра 12..18 = боковые грани
    RebroArr[i+12].e:= PointsArr[i+6];
  end;

  for i:=1 to 18 do
  begin
    RebroEkranArr[i].b:= Reform(RebroArr[i].b);
    RebroEkranArr[i].e:= Reform(RebroArr[i].e);
  end;

  for i := 1 to 8 do Gran[i]:= nil;
  SetLength(Gran[1], 6);
  SetLength(Gran[2], 6);
  SetLength(Gran[3], 4);
  SetLength(Gran[4], 4);
  SetLength(Gran[5], 4);
  SetLength(Gran[6], 4);
  SetLength(Gran[7], 4);
  SetLength(Gran[8], 4);
  Gran[1][0]:= 1;
  Gran[1][1]:= 2;
  Gran[1][2]:= 3;
  Gran[1][3]:= 4;
  Gran[1][4]:= 5;
  Gran[1][5]:= 6;
  Gran[2][0]:= 12;
  Gran[2][1]:= 11;
  Gran[2][2]:= 10;
  Gran[2][3]:= 9;
  Gran[2][4]:= 8;
  Gran[2][5]:= 7;
  Gran[3][0]:= 13;
  Gran[3][1]:= 7;
  Gran[3][2]:= 14;
  Gran[3][3]:= 1;
  Gran[4][0]:= 14;
  Gran[4][1]:= 8;
  Gran[4][2]:= 15;
  Gran[4][3]:= 2;
  Gran[5][0]:= 15;
  Gran[5][1]:= 9;
  Gran[5][2]:= 16;
  Gran[5][3]:= 3;
  Gran[6][0]:= 16;
  Gran[6][1]:= 10;
  Gran[6][2]:= 17;
  Gran[6][3]:= 4;
  Gran[7][0]:= 17;
  Gran[7][1]:= 11;
  Gran[7][2]:= 18;
  Gran[7][3]:= 5;
  Gran[8][0]:= 18;
  Gran[8][1]:= 12;
  Gran[8][2]:= 13;
  Gran[8][3]:= 6;
end;

{*****************  Проверка граней на видимость  *******************}
procedure TForm1.TestGranVis(Sender: TObject);
{********************************************************************}
var
  a, b, c: TTochka;
  Delta: integer;
  i: integer;
begin
  for i := 1 to 8 do
  begin
    if (RebroEkranArr[Gran[i][0]].e.x = RebroEkranArr[Gran[i][1]].b.x) and
       (RebroEkranArr[Gran[i][0]].e.y = RebroEkranArr[Gran[i][1]].b.y) then
    begin
      a:= RebroEkranArr[Gran[i][0]].b;
      b:= RebroEkranArr[Gran[i][0]].e;
      c:= RebroEkranArr[Gran[i][1]].e;
    end else
    begin
      if (RebroEkranArr[Gran[i][0]].e.x = RebroEkranArr[Gran[i][1]].e.x) and
         (RebroEkranArr[Gran[i][0]].e.y = RebroEkranArr[Gran[i][1]].e.y) then
      begin
        a:= RebroEkranArr[Gran[i][0]].b;
        b:= RebroEkranArr[Gran[i][0]].e;
        c:= RebroEkranArr[Gran[i][1]].b;
      end else
        begin
        if (RebroEkranArr[Gran[i][0]].b.x = RebroEkranArr[Gran[i][1]].e.x) and
           (RebroEkranArr[Gran[i][0]].b.y = RebroEkranArr[Gran[i][1]].e.y) then
        begin
          a:= RebroEkranArr[Gran[i][0]].e;
          b:= RebroEkranArr[Gran[i][0]].b;
          c:= RebroEkranArr[Gran[i][1]].b;
        end else
        begin
          if (RebroEkranArr[Gran[i][0]].b.x = RebroEkranArr[Gran[i][1]].b.x) and
             (RebroEkranArr[Gran[i][0]].b.y = RebroEkranArr[Gran[i][1]].b.y) then
          begin
            a:= RebroEkranArr[Gran[i][0]].e;
            b:= RebroEkranArr[Gran[i][0]].b;
            c:= RebroEkranArr[Gran[i][1]].e;
          end;
        end;
      end;
    end;
    Delta:= a.x*b.y - a.x*c.y - a.y*b.x + a.y*c.x + b.x*c.y - b.y*c.x;
    if Delta <= 0 then GranVis[i]:= True else GranVis[i]:= False;
  end;
end;

{*****************  Проверка ребер на видимость  ********************}
procedure TForm1.TestRebroVis(Sender: TObject);
{********************************************************************}
var
  i, j: integer;
begin
  for i := 1 to 18 do RebroVis[i]:= False;
  for i  := 1 to 8 do
  begin
    if GranVis[i] then
    for j := 0 to Length(Gran[i])-1 do
      RebroVis[Gran[i][j]]:= True;
  end;
end;

{********************  Рисование каркаса  ***************************}
procedure TForm1.PaintKarkas(Sender: TObject);
{********************************************************************}
var
  i: integer;
begin
  Image1.Canvas.Pen.Color:= clRed;
  for i := 1 to 18 do
  begin
    if RadioButton1.Checked then
    begin
      if RebroVis[i] then Image1.Canvas.Pen.Style:= psSolid else Image1.Canvas.Pen.Style:= psDash;
      Image1.Canvas.MoveTo(RebroEkranArr[i].b.x, RebroEkranArr[i].b.y);
      Image1.Canvas.LineTo(RebroEkranArr[i].e.x, RebroEkranArr[i].e.y);
    end else
    begin
      if RebroVis[i] then
      begin
        Image1.Canvas.Pen.Style:= psSolid;
        Image1.Canvas.MoveTo(RebroEkranArr[i].b.x, RebroEkranArr[i].b.y);
        Image1.Canvas.LineTo(RebroEkranArr[i].e.x, RebroEkranArr[i].e.y);
      end;
    end;
  end;
  Image1.Canvas.Pen.Style:= psSolid;
end;

{*********************  Отображение проекций  ***********************}
procedure TForm1.ProjectionBoxClick(Sender: TObject);
{********************************************************************}
begin
  if ProjectionBox.Checked then
  begin
    Image1.Canvas.Pen.Color:= clTeal;
    ViewProjection(Sender);
  end else
  begin
    Image1.Canvas.Pen.Color:= clWhite;
    ViewProjection(Sender);
  end;
end;

procedure TForm1.RadioButton1Click(Sender: TObject);
begin
    Image1.Canvas.Brush.Color:= clWhite;
    Image1.Canvas.FillRect(Image1.ClientRect);
    CalcPrism(Sender);
    ProjectionBoxClick(Sender);
    PaintCoordAxes(Sender);
    TestGranVis(Sender);
    TestRebroVis(Sender);
    PaintKarkas(Sender);
end;

procedure TForm1.RadioButton2Click(Sender: TObject);
begin
    Image1.Canvas.Brush.Color:= clWhite;
    Image1.Canvas.FillRect(Image1.ClientRect);
    CalcPrism(Sender);
    ProjectionBoxClick(Sender);
    PaintCoordAxes(Sender);
    TestGranVis(Sender);
    TestRebroVis(Sender);
    PaintKarkas(Sender);
end;

{*****************  Вращение объекта в цикле  ***********************}
procedure TForm1.RevolverBtnClick(Sender: TObject);
{********************************************************************}
begin
  while RevolverBtn.Down do
  begin
    Application.ProcessMessages;
    Image1.Canvas.Brush.Color:= clWhite;
    Image1.Canvas.FillRect(Image1.ClientRect);
    if Fi < 180 then Inc(Fi) else Fi:= -180;
    EditX.Text:= IntToStr(Fi);
    TrackBarX.Position:= Fi;
    CalcPrism(Sender);
    ProjectionBoxClick(Sender);
    PaintCoordAxes(Sender);
    TestGranVis(Sender);
    TestRebroVis(Sender);
    PaintKarkas(Sender);
    sleep(50);
  end;
end;

{************************  Расчет проекций  *************************}
procedure TForm1.CalcProjection(Sender: TObject);
{********************************************************************}
var
  i: integer;
begin
  for i := 1 to 18 do
  begin
    XYArr[i]:= RebroArr[i];
    XYArr[i].b.z:=0;
    XYArr[i].e.z:=0;
  end;
  for i := 1 to 18 do
  begin
    YZArr[i]:= RebroArr[i];
    YZArr[i].b.x:=0;
    YZArr[i].e.x:=0;
  end;
  for i := 1 to 18 do
  begin
    ZXArr[i]:= RebroArr[i];
    ZXArr[i].b.y:=0;
    ZXArr[i].e.y:=0;
  end;
end;


{*********************  Рисование проекций  *************************}
procedure TForm1.ViewProjection(Sender: TObject);
{********************************************************************}
var
  i: integer;
begin
  for i := 1 to 18 do
  begin
    Image1.Canvas.MoveTo(Reform(XYArr[i].b).x,Reform(XYArr[i].b).y);
    Image1.Canvas.LineTo(Reform(XYArr[i].e).x,Reform(XYArr[i].e).y);
  end;
  for i := 1 to 18 do
  begin
    Image1.Canvas.MoveTo(Reform(YZArr[i].b).x,Reform(YZArr[i].b).y);
    Image1.Canvas.LineTo(Reform(YZArr[i].e).x,Reform(YZArr[i].e).y);
  end;
  for i := 1 to 18 do
  begin
    Image1.Canvas.MoveTo(Reform(ZXArr[i].b).x,Reform(ZXArr[i].b).y);
    Image1.Canvas.LineTo(Reform(ZXArr[i].e).x,Reform(ZXArr[i].e).y);
  end;
end;

{***********  Изменение положения объекта вокру оси Х  **************}
procedure TForm1.TrackBarXChange(Sender: TObject);
{********************************************************************}
begin
  Image1.Canvas.Brush.Color:= clWhite;
  Image1.Canvas.FillRect(Image1.ClientRect);
  EditX.Text:= IntToStr(TrackBarX.Position);
  Fi:= TrackBarX.Position;
  PaintCoordAxes(Sender);
  CalcPrism(Sender);
  ProjectionBoxClick(Sender);
  TestGranVis(Sender);
  TestRebroVis(Sender);
  PaintKarkas(Sender);
end;

{***********  Изменение положения объекта вокру оси Y  **************}
procedure TForm1.TrackBarYChange(Sender: TObject);
begin
  Image1.Canvas.Brush.Color:= clWhite;
  Image1.Canvas.FillRect(Image1.ClientRect);
  EditY.Text:= IntToStr(TrackBarY.Position);
  Teta:= TrackBarY.Position;
  PaintCoordAxes(Sender);
  CalcPrism(Sender);
  ProjectionBoxClick(Sender);
  TestGranVis(Sender);
  TestRebroVis(Sender);
  PaintKarkas(Sender);
end;

{***********  Изменение положения объекта вокру оси Z  **************}
procedure TForm1.TrackBarZChange(Sender: TObject);
begin
  Image1.Canvas.Brush.Color:= clWhite;
  Image1.Canvas.FillRect(Image1.ClientRect);
  EditZ.Text:= IntToStr(TrackBarZ.Position);
  Psi:= TrackBarZ.Position;
  PaintCoordAxes(Sender);
  CalcPrism(Sender);
  ProjectionBoxClick(Sender);
  TestGranVis(Sender);
  TestRebroVis(Sender);
  PaintKarkas(Sender);
end;

procedure TForm1.Xbtn0Click(Sender: TObject);
begin
  TrackBarX.Position:= 0;
end;

procedure TForm1.Ybtn0Click(Sender: TObject);
begin
  TrackBarY.Position:= 0;
end;

procedure TForm1.Zbtn0Click(Sender: TObject);
begin
  TrackBarZ.Position:= 0;
end;

end.
