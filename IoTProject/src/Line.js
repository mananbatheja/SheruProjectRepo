import React from 'react';

function Line(props) {
    const {data} = props;
    const {tdata} = data;

    return (
        <div>
            {tdata}
        </div>   
    );
}

export default Line;