package org.techtown.retrofit2basic

import androidx.paging.PagingSource
import androidx.paging.PagingState
import java.io.IOException
/*
class ExamplePagingSource(
    val backend: ExampleBackendService
    val query: String
    /*
     * 추상 클래스인 PagingSource<Key : Any, Value : Any> 를 상속받아서 클래스 생성
     */
) : PagingSource<Int, User>() {
    /*
     * 사용자가 스크롤할 때 데이터를 비동기식으로 가져오기 위한 Load 함수
     * LoadParams 객체에는 로드할 페이지의 키와 로드 크기 정보가 저장된다.
     * 초기에는 key=null 이며 LoadSize는 가져온 데이터의 크기를 뜻한다.
     *  실패하면 LoadResult.Error 객체를 반환한다.
     */
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        try{
            // 페이지 번호가 지정되어있지 않다면 1페이지부터 시작
            val nextPageNumber = params.key ?: 1
            val response = backend.searchUsers(query, nextPageNumber) // 데이터 요청
            // 성공적으로 호출되면 데이터, 이전키, 다음키를 포함한 LoadResult.Page 객체를 반환한다.
            return LoadResult.Page(
                data = response.users,
                prevKey = null, // 다음 페이지 로드만 사용할 예정
                nextKey = response.nextPageNumber
            )
        } catch (e: IOException){
            // network failures
            return LoadResult.Error(e)
        } catch (e: IOException){
            // any non-2xx HTTP status codes
            return LoadResult.Error(e)
        }
    }

    // 새로고침할 때 다시 시작할 key를 반환한다.
    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        // 데이터가 첫 로드 후 새로고침 되거나 무효화 되었을 때 키를 반환하여
        // load() 메서드로 전달하여 다시 로딩
        return state.anchorPosition?.let{ anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1): anchorPage?.nextKey?.minus(1)
        }
    }
}
*/
