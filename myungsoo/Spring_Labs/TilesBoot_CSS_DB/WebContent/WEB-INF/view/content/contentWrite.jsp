<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<form name="db" action="writeok.db" method="POST"
		enctype="multipart/form-data">

		<table width="100%" border="0" align="center">


			<colgroup width="20%">
			<colgroup width="30%">
			<colgroup width="50%">
			<tr>
				<td align="left" colspan="2">
					<h2>
						<b>글 작성하기</b>
					</h2>
				</td>
				<td style="visibility: hidden;">empty</td>
				<td style="visibility: hidden;">empty</td>
			</tr>

			<tr>
				<td height="24px" align="center"></td>
				<td style="visibility: hidden;">empty</td>
				<td style="visibility: hidden;">empty</td>
			</tr>
			<tr>
				<td align="center" class="color">제목</td>
				<td align="left"><input type="text" class="form-control"
					name="title" id="title" size="50"></td>
				<td style="visibility: hidden;">empty</td>
			</tr>
			<tr>
				<td align="center"></td>
				<td style="visibility: hidden;">empty</td>
				<td style="visibility: hidden;">empty</td>
			</tr>
			<tr>
				<td align="center" class="color ">테마</td>
				<td><select name="theme" id="theme" class="form-control">
						<!-- 				<option data-class="podcast" >꽃놀이</option> -->
				</select></td>
				<td style="visibility: hidden;">empty</td>
			</tr>
			<tr>
				<td align="center"></td>
				<td style="visibility: hidden;">empty</td>
				<td style="visibility: hidden;">empty</td>
			</tr>
			<tr>
				<td align="center" class="color ">지역</td>
				<td><select name="regionselect" id="regionselect"
					class="form-control">
						<!--     					<option data-class="podcast">강남</option>   -->
				</select></td>
				<td style="visibility: hidden;">empty</td>
			<tr>
				<td align="center"></td>
				<td style="visibility: hidden;">empty</td>
				<td style="visibility: hidden;">empty</td>
			</tr>
			<tr>
				<td align="center" class="color ">예상 소요 시간</td>
				<td align="left"><select name="EXPECTEDHOUR" id="EXPECTEDHOUR"
					class="form-control">
						<option value="1">1시간</option>
						<option value="2">2시간</option>
						<option value="3">3시간</option>
						<option value="4">4시간</option>
						<option value="5">5시간</option>
				</select></td>
				<td style="visibility: hidden;">empty</td>
			</tr>
			<tr>
				<td align="center"></td>
				<td style="visibility: hidden;">empty</td>
				<td style="visibility: hidden;">empty</td>
			</tr>
			<tr>
				<td align="center"></td>
				<td style="visibility: hidden;">empty</td>
				<td style="visibility: hidden;">empty</td>
			</tr>
		</table>




		<table style="border: 1px solid black">
			<tr>
				<td><div id='View_area1'
						style='position: relative; width: 100px; height: 100px; color: black; border: 0px solid black; dispaly: inline;'></div></td>
				<td><div id='View_area2'
						style='position: relative; width: 100px; height: 100px; color: black; border: 0px solid black; dispaly: inline;'></div></td>
				<td><div id='View_area3'
						style='position: relative; width: 100px; height: 100px; color: black; border: 0px solid black; dispaly: inline;'></div></td>
				<td><div id='View_area4'
						style='position: relative; width: 100px; height: 100px; color: black; border: 0px solid black; dispaly: inline;'></div></td>
				<td><div id='View_area5'
						style='position: relative; width: 100px; height: 100px; color: black; border: 0px solid black; dispaly: inline;'></div></td>
			</tr>
			<tr>
				<td width="5%" align="center"><input type="file"
					class="form-control" accept="image/*" name="uploadfiles1"
					id="uploadfiles" onchange="previewImage(this,'View_area1')"></td>
				<td width="5%" align="center"><input type="file"
					class="form-control" accept="image/*" name="uploadfiles2"
					id="uploadfiles" onchange="previewImage(this,'View_area2')"></td>
				<td width="5%" align="center"><input type="file"
					class="form-control" accept="image/*" name="uploadfiles3"
					id="uploadfiles" onchange="previewImage(this,'View_area3')"></td>
				<td width="5%" align="center"><input type="file"
					class="form-control" accept="image/*" name="uploadfiles4"
					id="uploadfiles" onchange="previewImage(this,'View_area4')"></td>
				<td width="5%" align="center"><input type="file"
					class="form-control" accept="image/*" name="uploadfiles"
					id="uploadfiles" onchange="previewImage(this,'View_area5')"></td>
			</tr>

			<!-- <input type="file" name="profile_pt" id="profile_pt" onchange="previewImage(this,'View_area')">
					<div id='View_area' style='position:relative; width: 100px; height: 100px; color: black; border: 0px solid black; dispaly: inline; '></div> -->

		</table>


		<table width="100%" border="0" align="center">

			<tr>
				<td width="5%" align="center"></td>
				<td style="visibility: hidden;">empty</td>
			</tr>
			<tr>
				<td colspan="5"><textarea rows="10" cols="60" name="content"
						id="content">&nbsp;</textarea> <script type="text/javascript">
										var editor = CKEDITOR.replace('content',{
										});
									</script></td>
			</tr>
			<tr>
				<td width="5%" align="center"></td>
				<td style="visibility: hidden;">empty</td>
			</tr>
			<tr>
				<td width="5%" align="center"></td>
				<td style="visibility: hidden;">empty</td>
			</tr>
		</table>
	</form>
	<p align="right">
		<input class="btn btn btn-success btn-md text click" type="button"
			value="작성 하기" onclick="check()" /> <input
			class="btn btn btn-danger btn-md text click" type="button"
			value="작성 취소" onclick="back()" />
	</p>

