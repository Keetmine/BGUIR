object Form1: TForm1
  Left = 256
  Top = 119
  BorderIcons = [biSystemMenu, biMinimize]
  BorderStyle = bsSingle
  Caption = #1047#1072#1076#1072#1085#1080#1077' '#8470'4 '
  ClientHeight = 510
  ClientWidth = 778
  Color = clBtnFace
  Font.Charset = DEFAULT_CHARSET
  Font.Color = clWindowText
  Font.Height = -11
  Font.Name = 'Tahoma'
  Font.Style = []
  OldCreateOrder = False
  OnCreate = FormCreate
  PixelsPerInch = 96
  TextHeight = 13
  object Label1: TLabel
    Left = 650
    Top = 13
    Width = 28
    Height = 13
    Caption = #1054#1089#1100' X'
    Visible = False
  end
  object Label2: TLabel
    Left = 650
    Top = 69
    Width = 28
    Height = 13
    Caption = #1054#1089#1100' Y'
    Visible = False
  end
  object Label3: TLabel
    Left = 650
    Top = 125
    Width = 28
    Height = 13
    Caption = #1054#1089#1100' Z'
    Visible = False
  end
  object Xbtn0: TSpeedButton
    Left = 561
    Top = 32
    Width = 23
    Height = 21
    Caption = '0'
    Visible = False
    OnClick = Xbtn0Click
  end
  object Ybtn0: TSpeedButton
    Left = 561
    Top = 88
    Width = 23
    Height = 21
    Caption = '0'
    Visible = False
    OnClick = Ybtn0Click
  end
  object Zbtn0: TSpeedButton
    Left = 561
    Top = 144
    Width = 23
    Height = 21
    Caption = '0'
    Visible = False
    OnClick = Zbtn0Click
  end
  object RevolverBtn: TSpeedButton
    Left = 590
    Top = 224
    Width = 155
    Height = 22
    AllowAllUp = True
    GroupIndex = -6
    Caption = #1042#1088#1072#1097#1077#1085#1080#1077' '#1074#1086#1082#1088#1091#1075' '#1086#1089#1080' X'
    OnClick = RevolverBtnClick
  end
  object Panel1: TPanel
    Left = 0
    Top = 0
    Width = 551
    Height = 510
    Align = alLeft
    TabOrder = 0
    object Image1: TImage
      Left = 1
      Top = 1
      Width = 549
      Height = 508
      Align = alClient
    end
  end
  object EditX: TEdit
    Left = 734
    Top = 32
    Width = 31
    Height = 21
    ReadOnly = True
    TabOrder = 1
    Text = '0'
    Visible = False
  end
  object EditY: TEdit
    Left = 734
    Top = 88
    Width = 31
    Height = 21
    ReadOnly = True
    TabOrder = 2
    Text = '0'
    Visible = False
  end
  object EditZ: TEdit
    Left = 734
    Top = 144
    Width = 31
    Height = 21
    ReadOnly = True
    TabOrder = 3
    Text = '0'
    Visible = False
  end
  object RadioButton1: TRadioButton
    Left = 894
    Top = 28
    Width = 64
    Height = 17
    Caption = #1050#1072#1088#1082#1072#1089
    Checked = True
    TabOrder = 4
    TabStop = True
    OnClick = RadioButton1Click
  end
  object RadioButton2: TRadioButton
    Left = 892
    Top = 52
    Width = 64
    Height = 17
    Caption = #1043#1088#1072#1085#1080
    TabOrder = 5
    OnClick = RadioButton2Click
  end
  object ProjectionBox: TCheckBox
    Left = 590
    Top = 200
    Width = 148
    Height = 17
    Caption = #1055#1086#1089#1084#1086#1090#1088#1077#1090#1100' '#1087#1088#1086#1077#1082#1094#1080#1080
    TabOrder = 6
    Visible = False
    OnClick = ProjectionBoxClick
  end
  object TrackBarX: TTrackBar
    Left = 584
    Top = 30
    Width = 150
    Height = 29
    Max = 180
    Min = -180
    TabOrder = 7
    Visible = False
    OnChange = TrackBarXChange
  end
  object TrackBarY: TTrackBar
    Left = 584
    Top = 86
    Width = 150
    Height = 29
    Max = 180
    Min = -180
    TabOrder = 8
    Visible = False
    OnChange = TrackBarYChange
  end
  object TrackBarZ: TTrackBar
    Left = 584
    Top = 142
    Width = 150
    Height = 29
    Max = 180
    Min = -180
    TabOrder = 9
    Visible = False
    OnChange = TrackBarZChange
  end
end
