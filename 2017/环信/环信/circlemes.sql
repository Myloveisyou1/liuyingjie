USE [manji]
GO
/****** Object:  Table [dbo].[cir_msg]    Script Date: 2017/5/12 9:48:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[cir_msg](
	[msgid] [varchar](20) NOT NULL,
	[timestamp] [varchar](20) NULL,
	[send] [varchar](20) NULL,
	[recieve] [varchar](20) NULL,
	[chat] [varchar](10) NULL,
	[type] [varchar](10) NULL,
	[msg] [varchar](100) NULL,
	[state] [varchar](1) NULL,
	[remark] [varchar](400) NULL,
	[ext] [varchar](1000) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[cir_token]    Script Date: 2017/5/12 9:48:13 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[cir_token](
	[token] [varchar](200) NULL,
	[create_time] [varchar](50) NULL,
	[expires_in] [varchar](50) NULL,
	[application] [varchar](200) NULL,
	[way] [varchar](50) NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[cir_token] ([token], [create_time], [expires_in], [application], [way]) VALUES (N'YWMtFhRIRDRjEee2nBWzLnyTAwAAAAAAAAAAAAAAAAAAAAF5sPSAH_gR56U4ScmjLTgjAgMAAAFb6yLhxABPGgDbpJSNRQYbye2y4jjBt5203qA22FOklkE1jgnAVn4hOw', N'2017-05-12 09:38:44', N'4929477', N'79b0f480-1ff8-11e7-a538-49c9a32d3823', N'手动获取')
